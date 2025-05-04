import { NextFunction, Request, Response, Router } from "express";
import { ControllerStudent } from "../estudiante/infrastructure/controller/controllerStudent.controller";

const ruta=Router()
const controlador=new ControllerStudent()

/* ruta.get("/testing",(req:Request,res:Response)=>{
    res.send(`!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!`)
}) */

ruta.get("/html",controlador.getAll)
ruta.get("/html/:id",controlador.getOneById)
ruta.post("/html",controlador.create)
ruta.put("/html/:id",controlador.edit)
ruta.delete("/html/:id",controlador.delete)

export {ruta}
