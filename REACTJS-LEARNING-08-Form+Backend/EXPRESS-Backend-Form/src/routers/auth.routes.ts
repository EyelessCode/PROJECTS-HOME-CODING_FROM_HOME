import { Router } from "express";
import { requiredAuth, requiredRole } from "../middlewares/auth.middlewares";
import { login, register } from "../controllers/user.controller";

const router=Router()
router.post("/login",login)
router.post("/register",register)
router.use(requiredAuth)
router.use(requiredRole)

export default router
