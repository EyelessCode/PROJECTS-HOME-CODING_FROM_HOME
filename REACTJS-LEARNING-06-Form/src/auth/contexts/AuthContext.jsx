import { createContext, useContext, useEffect, useState } from "react"
import { users } from "../../data/fakeUser"

const AuthContext=createContext()

export const AuthProvider = ({children}) => {
    const [user,setUser]=useState(null)

    useEffect(()=>{
        const storagedUser=localStorage.getItem("user")
        if(storagedUser)setUser(JSON.parse(storagedUser))
    },[])

    const login=(username,password)=>{
        const userFound=users.find(u=>u.username===username)

        if(!userFound)throw new Error("Usuario no encontrado.")
        if(userFound.password!==password)throw new Error("Contraseña incorrecta.")
        setUser(userFound)
        localStorage.setItem("user",JSON.stringify(userFound))
    }

    const register=(username,password)=>{
        // if(!username||!password)throw new Error("Ambos campos son obligatorios.")

        if(username.length<4)throw new Error("El usuario debe de tener más de 3 caractéres.")
        if(password.length<6)throw new Error("La contraseña debe de tener al menos 6 caractéres.")
        const usernameUsed=users.some(u=>u.username===username)
        if(usernameUsed)throw new Error("El nombre de usuario ya está en uso.")
        const newUser={
            id:users.length+1,
            username:username,
            password:password,
            role:"user"
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
        <AuthContext.Provider value={{login,user,register,logOut}}>{children}</AuthContext.Provider>
    )
}

export const useAuth=()=>useContext(AuthContext)
