import { createContext, useContext, useState } from "react"

const AuthContext=createContext()

export const AuthProvider = ({children}) => {
    const [user,setUser]=useState(null)
    
    const login=(username,password)=>{
        setUser({username})
    }

    const register=(username,password)=>{
        setUser({username})
    }

    const logout=()=>setUser(null)
    
    return (
        <AuthContext.Provider value={{user,login,register,logout}}>{children}</AuthContext.Provider>
    )
}

export const userAuth=()=>useContext(AuthContext)
