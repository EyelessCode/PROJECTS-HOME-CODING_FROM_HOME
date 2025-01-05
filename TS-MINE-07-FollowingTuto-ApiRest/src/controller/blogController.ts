import { Request, Response } from "express"
import { handleHttp } from "../util/error.handle"
import { insertItem } from "../service/itemService"

const getItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_GET_BLOG')
    }
}

const getItems=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_GET_BLOGS')
    }
}

const update=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_UPDATE_BLOG')
    }
}

const createItem=async({body}:Request,res:Response)=>{
    try {

    } catch (error) {
        handleHttp(res,'ERROR_CREATE_BLOG',error)
    }
}

const deleteItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        handleHttp(res,'ERROR_DELETE_BLOG')
    }
}

export {getItem,getItems,update,createItem,deleteItem}