import { Request, Response } from "express"
import { handleHttp } from "../util/error.handle"
import { insertItem } from "../service/itemService"

const getItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_GET_ITEM')
    }
}

const getItems=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_GET_ITEMS')
    }
}

const update=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_UPDATE_ITEM')
    }
}

const createItem=async({body}:Request,res:Response)=>{
    try {
        const responseItem=await insertItem(body)
        res.send(responseItem)
    } catch (error) {
        handleHttp(res,'ERROR_CREATE_ITEM',error)
    }
}

const deleteItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_DELETE_ITEM')
    }
}

export {getItem,getItems,update,createItem,deleteItem}