import type { Request, Response } from "express";
import { loginUser, registerUser } from "../services/user.service";

export const register=async(req:Request,res:Response):Promise<void>=>{
    try {
        const {username,password}=req.body
        const data=await registerUser(username,password)
        res.json(data)
    } catch (error) {
        const message=error instanceof Error?error.message:
            "¡Un error inesperado ha ocurrido en el proceso de Register!"
        res.status(400).json({message})
    }
}

export const login=async(req:Request,res:Response):Promise<void>=>{
    try {
        const {username,password}=req.body
        const data=await loginUser(username,password)
        res.json(data)
    } catch (error) {
        const message=error instanceof Error?error.message:
            "¡Un error inesperado ha ocurrido en el proceso de Login!"
        res.status(400).json({message})
    }
}
