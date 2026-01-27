import { users } from "../data/users.data.js"
import bcrypt from 'bcrypt'
import { generateToken } from "../utils/jwt.js"

export const registerUser=async(username,password)=>{
    const exists=users.find(u=>u.username===username)
    if(exists)throw new Error("El nombre de usuario ya está en uso.")

    const hashedPassword=await bcrypt.hash(password,10)

    const newUser={
        id:users.length+1,
        username:username,
        password:hashedPassword,
        role:"user"
    }

    users.push(newUser)

    const token=generateToken({
        id:newUser.id,
        role:newUser.role
    })

    return token
}

export const loginUser=async(username,password)=>{
    const user=users.find(u=>u.username===username)
    if(!user)throw new Error("No se encontró el usuario.")

    const isValid=await bcrypt.compare(password,user.password)
    if(!isValid)throw new Error("Contraseña incorrecta.")
    
    const token=generateToken({
        id:user.id,
        role:user.role
    })

    return token
}
