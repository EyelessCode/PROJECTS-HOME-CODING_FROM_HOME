import type { UserPayload, UserPayloadPublic } from "../middlewares/@types/user.types"
import { users } from "../stores/user.store"
import bcrypt from 'bcrypt'
import { generateToken } from "../utils/jwt.token"

export const registerUser=async(username:string,password:string)=>{
    const exist=users.find((u)=>u.username===username)
    if(exist)throw new Error(`El usuario ${username} ya existe.`)

    const hashedPassword=await bcrypt.hash(password,10)
    const newUser:UserPayload={
        id:users.length+1,
        username:username,
        password:hashedPassword,
        role:"user"
    }

    const userPublic:UserPayloadPublic={
        id:newUser.id,
        username:newUser.username,
        role:newUser.role
    }

    users.push(newUser)
    const token=generateToken(userPublic)

    return {token,user:userPublic}
}

export const loginUser=async(username:string,password:string)=>{
    const user=users.find((u)=>u.username===username)
    if(!user)throw new Error(`No se encontró el usuario ${username}.`)
    const comparedPassword=await bcrypt.compare(password,user.password)
    if(!comparedPassword)throw new Error("Contraseña incorrecta.")
    
    const userPublic:UserPayloadPublic={
        id:user.id,
        username:user.username,
        role:user.role
    }
    const token=generateToken(userPublic)
    return {token,user:userPublic}
}
