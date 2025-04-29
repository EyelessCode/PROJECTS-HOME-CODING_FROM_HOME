import { Request, Response, Router } from "express";

export const ruta=Router()
ruta.get('/main',(req:Request,res:Response)=>{
    res.send(`Hola`)
})
