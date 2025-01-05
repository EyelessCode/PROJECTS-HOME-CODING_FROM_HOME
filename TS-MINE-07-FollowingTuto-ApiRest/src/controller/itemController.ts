import { Request, Response } from "express"
import { handleHttp } from "../util/error.handle"

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

const createItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_CREATE_ITEM')
    }
}

const deleteItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_DELETE_ITEM')
    }
}

export {getItem,getItems,update,createItem,deleteItem}