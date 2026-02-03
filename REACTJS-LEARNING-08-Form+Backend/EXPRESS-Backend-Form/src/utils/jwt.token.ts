import jwt from 'jsonwebtoken'
import "dotenv/config"
import type { UserPayload, UserPayloadPublic } from '../middlewares/@types/user.types'

const SECRET:any=process.env.SECRET

export const generateToken=(payload:UserPayload|UserPayloadPublic):string=>{
    return jwt.sign(payload,SECRET,{
        expiresIn:"1h"
    })
}

export const verifyToken=(token:string):UserPayload=>{
    return jwt.verify(token,SECRET) as UserPayload
}
