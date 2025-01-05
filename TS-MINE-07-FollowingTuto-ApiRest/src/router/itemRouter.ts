import { Request, Response, Router } from "express";
import { createItem, deleteItem, getItem, getItems, update } from "../controller/itemController";

const router=Router()

/* router.get('/',(req:Request,res:Response)=>{
    res.send({
        data:"MODELS_HERE"
    })
}) */

    router.get("/",getItems)
    router.get("/:id",getItem)
    router.post("/",createItem)
    router.put("/:id",update)
    router.delete("/:id",deleteItem)

export {router};
