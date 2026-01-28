import React, { createContext, useContext, useEffect, useState } from "react"
import type { AuthContextType, UserPayload } from "../@types/auth/auth.types"
import { loginRequest, registerRequest } from "../services/auth/auth.service"

const AuthContext=createContext<AuthContextType|null>(null)

export const AuthProvider = ({children}:{children:React.ReactNode}) => {
    const [user,setUser]=useState<UserPayload|null>(null)
    const [token,setToken]=useState<string|null>(null)

    const login=async(username:string,password:string)=>{
        const {token,user}=await loginRequest(username,password)

        setUser(user)
        setToken(token)

        localStorage.setItem("token",token)
        localStorage.setItem("user",JSON.stringify(user))
    }

    const logout=()=>{
        setUser(null)
        setToken(null)
        localStorage.clear()
    }

    const register=async(username:string,password:string)=>{
        const {token,user}=await registerRequest(username,password)

        setUser(user)
        setToken(token)

        localStorage.setItem("token",token)
        localStorage.setItem("user",JSON.stringify(user))
    }

    useEffect(()=>{
        const storedUser=localStorage.getItem("user")
        const storedToken=localStorage.getItem("token")

        if(storedUser&&storedToken){
            setUser(JSON.parse(storedUser))
            setToken(storedToken)
        }
    },[])
    return <AuthContext.Provider value={{user,token,login,logout,register}}>{children}</AuthContext.Provider>
}

export const useAuth=()=>{
    const ctx=useContext(AuthContext)
    if(!ctx)throw new Error("'useAuth' no debería ser usado sin el 'AuthProvider'.")
    return ctx
}

