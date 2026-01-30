import { Router } from "express"
import { login, register } from "../controllers/user.controller.js"
import { requiredAuth } from "../middlewares/auth.middleware.js"

const router=Router()

router.get("/ping",(req,res)=>{
    res.json({message:"Auth routes funcionando!"})
})

router.post("/register",register)
router.post("/login",login)
router.use(requiredAuth)

export default router
