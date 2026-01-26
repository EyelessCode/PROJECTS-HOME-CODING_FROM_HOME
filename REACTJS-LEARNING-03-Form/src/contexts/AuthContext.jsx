import { createContext, useContext, useState } from "react"
import { users } from "../data/user"

const AuthContext=createContext()

export const AuthProvider = ({children}) => {
    const [user,setUser]=useState(null)
    
    const logIn=(username,password)=>{
        const userFound=users.find(u=>u.username===username)
        if(!userFound)throw new Error("Credenciales Incorrectos")

        if(password!==userFound.password)throw new Error("Contraseña incorrecta")
        // users.push(userFound)
        setUser(userFound)
    }

    const register=(username,password)=>{
        const newUser={
            id:users.length+1,
            username,
            password
        }
        users.push(newUser)
        setUser(newUser)
    }

    const logOut=()=>setUser(null)
    return (
        <AuthContext.Provider value={{user,logIn,register,logOut}}>{children}</AuthContext.Provider>
    )
}

export const useAuth=()=>useContext(AuthContext)
