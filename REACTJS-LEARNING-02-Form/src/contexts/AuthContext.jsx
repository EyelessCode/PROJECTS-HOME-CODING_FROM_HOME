import { createContext, useContext, useState } from "react";
import { users } from "../data/user";

const AuthContext=createContext()

export const AuthProvider = ({children}) => {
    const [user,setUser]=useState(null)

    const form=(username,password)=>{
        const isUser=users.find(u=>u.username===username&&u.password===password)
        if(isUser){
            if(isUser.password!==password){
                throw new Error("Credenciales incorrectas.")
            }
            setUser(isUser)
        }else{
            const newUser={
                id:users.length+1,
                username,
                password
            }
        users.push(newUser)
        setUser(newUser)
        }
    }
    const logout=()=>setUser(null)

    return (
        <AuthContext.Provider value={{user,form,logout}}>
            {children}
        </AuthContext.Provider>
    )
}

export const useAuth=()=>useContext(AuthContext)
