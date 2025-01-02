import { Request, Response, Router } from "express";

const router=Router()

router.get('/item',(req:Request,res:Response)=>{
    res.send({
        data:"MODELS_HERE"
    })
})

export default router;