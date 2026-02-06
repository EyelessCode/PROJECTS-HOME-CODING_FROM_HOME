import { createContext, type ReactNode } from "react";
import { type UserPayload } from "@/index"

export interface AuthContextProps{
    children:ReactNode
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
