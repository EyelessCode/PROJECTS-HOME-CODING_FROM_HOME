import { verifyToken } from "../utils/jwt.js"

export const requiredAuth=(req,res,next)=>{
    const header=req.headers.authorization

    if(!header)return res.status(401).json({message:"TOKEN REQUERIDO"})

    const token=header.split(" ")[1]

    try {
        const decoded=verifyToken(token)
        req.user=decoded
        next()
    } catch (err) {
        res.status(401).json({message:"TOKEN INVÁLIDO"})
    }
}
