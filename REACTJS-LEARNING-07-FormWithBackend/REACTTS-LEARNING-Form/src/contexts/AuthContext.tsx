import React, { createContext, useContext, useEffect, useState } from "react"
import type { AuthContextType, UserPayload } from "../@types/auth/auth.types"
import { loginRequest, registerRequest } from "../services/auth/auth.service"
import { useNavigate } from "react-router-dom"
import { authRedirectByRole } from "../routers/auhtRedirect"

const AuthContext=createContext<AuthContextType|null>(null)

export const AuthProvider = ({children}:{children:React.ReactNode}) => {
    const navigate=useNavigate()
    const [user,setUser]=useState<UserPayload|null>(null)
    const [token,setToken]=useState<string|null>(null)
    const [loading,setLoading]=useState(true)

    const login=async(username:string,password:string)=>{
        const {token,user}=await loginRequest(username,password)
        // const {token}=await loginRequest(username,password)

        
        setUser(user)
        setToken(token)
        localStorage.setItem("token",token)
        localStorage.setItem("user",JSON.stringify(user))
        navigate(authRedirectByRole(user.role))
        
    }

    const logout=()=>{
        localStorage.clear()
        setUser(null)
        setToken(null)
    }

    const register=async(username:string,password:string)=>{
        const {token,user}=await registerRequest(username,password)
        // const {token}=await registerRequest(username,password)

        
        setUser(user)
        setToken(token)
        localStorage.setItem("token",token)
        localStorage.setItem("user",JSON.stringify(user))
        navigate(authRedirectByRole(user.role))
    }

    useEffect(()=>{
        const storedToken=localStorage.getItem("token")
        const storedUser=localStorage.getItem("user")

        try {
            if(storedUser&&storedToken){
                const parsedUser=JSON.parse(storedUser)
                setUser(parsedUser)
                setToken(storedToken)
            }
        } catch (err) {
            localStorage.clear()
        }finally{
            setLoading(false)
        }
    },[])
    return <AuthContext.Provider value={{user,token,login,logout,register,loading}}>{children}</AuthContext.Provider>
}

export const useAuth=()=>{
    const ctx=useContext(AuthContext)
    if(!ctx)throw new Error("'useAuth' no debería ser usado sin el 'AuthProvider'.")
    return ctx
}

