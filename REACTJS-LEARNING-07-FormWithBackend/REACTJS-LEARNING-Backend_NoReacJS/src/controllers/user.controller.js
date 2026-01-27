import { loginUser, registerUser } from "../services/user.service.js"

export const register=async(req,res)=>{
    try {
        const {username,password}=req.body
        const token=await registerUser(username,password)
        res.json({token})
    } catch (err) {
        res.status(400).json({message:err.message})
    }
}

export const login=async(req,res)=>{
    try {
        const {username,password}=req.body
        const token=await loginUser(username,password)
        res.json({token})
    } catch (err) {
        res.status(400).json({message:err.message})
    }
}
