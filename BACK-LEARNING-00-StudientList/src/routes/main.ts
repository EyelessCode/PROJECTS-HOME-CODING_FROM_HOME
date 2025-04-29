import { Request, Response, Router } from "express";

const ruta=Router()

ruta.get("/html",(req:Request,res:Response)=>{
    res.send(`!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!`)
})

export {ruta}
