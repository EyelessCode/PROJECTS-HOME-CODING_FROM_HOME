import React, { createContext, useContext, useEffect, useState } from "react"
import type { AuthContextType, UserPayload } from "../@types/auth/auth.types"
import { loginRequest, registerRequest } from "../services/auth/auth.service"

const AuthContext=createContext<AuthContextType|null>(null)

export const AuthProvider = ({children}:{children:React.ReactNode}) => {
    const [user,setUser]=useState<UserPayload|null>(null)
    const [token,setToken]=useState<string|null>(null)
    const [loading,setLoading]=useState(true)

    const login=async(username:string,password:string)=>{
        const {token,user}=await loginRequest(username,password)

        
        setUser(user)
        setToken(token)
        localStorage.setItem("token",token)
        localStorage.setItem("user",JSON.stringify(user))
    }

    const logout=()=>{
        localStorage.clear()
        setUser(null)
        setToken(null)
    }

    const register=async(username:string,password:string)=>{
        const {token,user}=await registerRequest(username,password)

        
        setUser(user)
        setToken(token)
        localStorage.setItem("token",token)
        localStorage.setItem("user",JSON.stringify(user))
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
            console.error("Error leyendo Auth desde localStorage ",err);
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

