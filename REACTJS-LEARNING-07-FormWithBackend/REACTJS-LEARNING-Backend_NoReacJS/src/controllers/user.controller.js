import { loginUser, registerUser } from "../services/user.service.js"

export const register=async(req,res)=>{
    try {
        // console.log("HEADERS:", req.headers)
        // console.log("BODY:", req.body)
        const {username,password}=req.body
        const authData=await registerUser(username,password)
        res.json({authData})
    } catch (err) {
        res.status(400).json({message:err.message})
    }
}

export const login=async(req,res)=>{
    try {
        // console.log("HEADERS:", req.headers)
        // console.log("BODY:", req.body)
        const {username,password}=req.body
        const authData=await loginUser(username,password)
        res.json({authData})
    } catch (err) {
        res.status(400).json({message:err.message})
    }
}
