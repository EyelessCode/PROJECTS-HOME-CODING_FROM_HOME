import { NextFunction, Request, Response } from "express";
import { container } from "../../../shared/infrastructure/containerServices.shared";
import { StudentNotFound } from "../../domain/validation/util/studentNotFound.util";

export class ControllerStudent{
    async getAll(req:Request,res:Response,next:NextFunction){
        try {
            const student=await container.student.getAll.run()
            return res.json(student.map((s)=>s.mapeoPrimitivo())).status(200)
        } catch (error) {
            next(error)
        }
    }

    async getOneById(req:Request,res:Response,next:NextFunction){
        try {
            const student=await container.student.getOneById.run(Number(req.params.id))
            return res.json(student.mapeoPrimitivo()).status(200)
        } catch (error) {
            if (error instanceof StudentNotFound) {
                return res.status(404).json({
                    message:error.message
                })
            }

            next(error)
        }
    }

    async create(req:Request,res:Response,next:NextFunction){
        try {
            const {id,nombre,apellido,edad}=req.body as {
                id:number,nombre:string,apellido:string,
                edad:number
            }

            await container.student.create.run(id,nombre,apellido,edad)

            return res.status(201).send()
        } catch (error) {
            next(error)
        }
    }

    async edit(req:Request,res:Response,next:NextFunction){
        try {
            const {id,nombre,apellido,edad}=req.body as {
                id:number,nombre:string,apellido:string,
                edad:number
            }

            await container.student.edit.run(id,nombre,apellido,edad)

            return res.status(204).send()
        } catch (error) {
            if(error instanceof StudentNotFound){
                res.status(404).json({
                    message:error.message
                })
            }

            next(error)
        }
    }

    async delete(req:Request,res:Response,next:NextFunction){
        try {
            await container.student.delete.run(Number(req.params.id))
            
            return res.status(204).send()
        } catch (error) {
            if(error instanceof StudentNotFound){
                res.status(404).json({
                    message:error.message
                })
            }

            next(error)
        }
    }

}
