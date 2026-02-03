import type React from "react";
import { createContext } from "react";
import type { UserPayload } from "../users/user.type";

export interface AuthContextProps{
    children:React.ReactNode
}

export interface AuthContextType{
    user:UserPayload|null
    login:(username:string,password:string)=>void
    register:(username:string,password:string)=>void
    token:string|null
    loading:boolean
    logout:()=>void
}

export const AuthContext=createContext<AuthContextType|null>(null)
