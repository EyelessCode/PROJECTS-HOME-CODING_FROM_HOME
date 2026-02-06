import { AuthContext, loginRequest, registerRequest, type AuthContextProps, type UserPayload } from "@/index"
import { useContext, useEffect, useState } from "react"

export const AuthProvider = ({children}:AuthContextProps) => {
    const [loading,setLoading]=useState<boolean>(true)
    const [token,setToken]=useState<string|null>(null)
    const [user,setUser]=useState<UserPayload|null>(null)

    const login=async(username:string,password:string):Promise<void>=>{
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

    const register=async(username:string,password:string):Promise<void>=>{
        const {token,user}=await registerRequest(username,password)
        setUser(user)
        setToken(token)
        localStorage.setItem("token",token)
        localStorage.setItem("user",JSON.stringify(user))
    }

    useEffect(()=>{
        try {
            const storedUser=localStorage.getItem("user")
            const storedToken=localStorage.getItem("token")
            if(storedToken&&storedUser){
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
    return <AuthContext.Provider
        value={{loading,login,logout,register,token,user}}>{children}</AuthContext.Provider>
}

export const useAuth=()=>{
    const ctx=useContext(AuthContext)
    if(!ctx)throw new Error("No puedes usar estados de Autenticación sin el Provedor.")
    return ctx
}
