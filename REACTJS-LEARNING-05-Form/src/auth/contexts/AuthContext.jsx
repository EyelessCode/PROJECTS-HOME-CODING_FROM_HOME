import { createContext, useContext, useEffect, useState } from "react"
import { users } from "../fakeUsers"

const AuthContext=createContext()

export const AuthProvider = ({children}) => {
    const [user,setUser]=useState(null)

    useEffect(()=>{
        const storedUser=localStorage.getItem("user")
        if(storedUser)setUser(JSON.parse(storedUser))
    },[])

    const login=(username,password)=>{
        const userFound=users.find(u=>u.username===username)
        if(!userFound)throw new Error("Usuario no existe")
        if(userFound.password!==password)throw new Error("Contraseña incorrecta.")
        
        setUser(userFound)
        localStorage.setItem("user",JSON.stringify(userFound))
    }

    const register=(username,password)=>{
        const newUser={
            id:users.length+1,
            username,
            password
        }
        users.push(newUser)
        setUser(newUser)
        localStorage.setItem("user",JSON.stringify(newUser))
    }

    const logOut=()=>{
        setUser(null)
        localStorage.removeItem("user")
    }
    return (
        <AuthContext.Provider value={{user,login,register,logOut}}>{children}</AuthContext.Provider>
    )
}

export const useAuth=()=>{
    return useContext(AuthContext)
}
