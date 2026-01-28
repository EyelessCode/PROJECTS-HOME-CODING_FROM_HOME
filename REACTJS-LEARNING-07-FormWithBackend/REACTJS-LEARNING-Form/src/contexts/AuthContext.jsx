import { createContext, useContext, useState } from "react"
import { loginRequest, registerRequest } from "../apis/auth/auth"

const AuthContext=createContext()

export const AuthProvider = ({children}) => {
    const [token,setToken]=useState(
        localStorage.getItem("token")
    )

    const login=async(username,password)=>{
        const {token}=await loginRequest(username,password)
        localStorage.setItem("token",token)
        setToken(token)
    }

    const register=async(username,password)=>{
        const {token}=await registerRequest(username,password)
        localStorage.setItem("token",token)
        setToken(token)
    }

    const logOut=()=>{
        localStorage.removeItem("token")
        setToken(null)
    }

    return (
        <AuthContext.Provider value={{token,login,logOut,register}}>{children}</AuthContext.Provider>
    )
}

export const useAuth=()=>useContext(AuthContext)

