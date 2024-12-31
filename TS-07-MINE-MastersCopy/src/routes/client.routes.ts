import { Router } from "express";
import { ClientController } from "../controller/client.controller";

const router=Router()
const controller=new ClientController()

router.get('/client',controller.getAllController)
router.get('/client:id',controller.getByIdController)
router.post('/client/',controller.createController)
router.put('/client:id',controller.updateController)
router.delete('/client/:id',controller.deleteController)

export default router;