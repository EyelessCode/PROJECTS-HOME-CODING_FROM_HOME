import type { NextFunction, Request, Response } from "express";
import { verifyToken } from "../utils/jwt.token";

declare global {
    namespace Express {
        interface Request {
        user?: any;
        }
    }
}

export const requiredAuth=(req:Request,res:Response,next:NextFunction):void=>{
    const header=req.headers.authorization

    if(!header){
        res.status(401).json({message:"TOKEN REQUERIDO."})
        return
    }
    
    const token:any=header.split(" ")[1]
    try {
        const decoded=verifyToken(token)
        req.user=decoded
        next()
    } catch (err) {
        res.status(401).json({message:"TOKEN INVÁLIDO."})
    }
}

export const requiredRole=(role:string)=>{
    return (req:Request,res:Response,next:NextFunction):void=>{
        const user=req.user

        if(!user){
            res.status(401).json({message:"NO AUTENTICADO."})
            return
        }
        if(!role.includes(user.role)){
            res.status(403).json({message:"NO AUTORIZADO."})
            return
        }
        next()
    }
}
