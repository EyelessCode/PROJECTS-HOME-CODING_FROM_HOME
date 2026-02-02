import { Router } from "express";
import { requiredAuth } from "../middlewares/auth.middlewares";

const router=Router()
router.use(requiredAuth)

export default router
