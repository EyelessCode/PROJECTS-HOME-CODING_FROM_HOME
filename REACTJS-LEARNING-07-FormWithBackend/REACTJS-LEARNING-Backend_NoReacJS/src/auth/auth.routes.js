import { Router } from "express"
import { login, register } from "../controllers/user.controller.js"

const router=Router()

router.get("/ping",(req,res)=>{
    res.json({message:"Auth routes funcionando!"})
})

router.post("/register",register)
router.post("/login",login)

export default router
