import { Request, Response } from "express";
import { IEndpointsInterface } from "../interface/iEndpoints.interface";
import { ClientRepository } from "../repository/client.repository";

export class ClientController{
    private clients: IEndpointsInterface;

    constructor(repository:IEndpointsInterface=new ClientRepository()) {
        this.clients=repository
    }

    getAllController=(req:Request,res:Response):void=>{
        let client=this.clients.getAll()
        res.json(client)
    }

    getByIdController=(req:Request,res:Response):void=>{
        let code=parseInt(req.params.id)

        let client=this.clients.getById(code)

        if(client){
            res.json(client)
        }else{
            res.status(404).json({
                message:"Client not found"
            })
        }
    }

    createController=(req:Request,res:Response):void=>{
        let client=this.clients.create(req.body)
        res.status(201).json(client)
    }

    updateController=(req:Request,res:Response):void=>{
        let code=parseInt(req.params.id)

        let updateClient=this.clients.update(code,req.body)

        if (updateClient) {
            res.json(updateClient)
        }else{
            res.status(404).json({
                message:"Client not found"
            })
        }
    }

    deleteController=(req:Request,res:Response):void=>{
        let code=parseInt(req.params.id)
        
        let deleteClient=this.clients.delete(code)

        if (deleteClient) {
            res.status(200).json({
                message: "Client deleted"
            })
        } else {
            res.status(404).json({
                message: "Client not found"
            })
        }
    }
}