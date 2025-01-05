import { Request, Response } from "express"

const getItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        res.status(500)
        res.send('EROR_GET_ITEM')
    }
}

const getItems=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        res.status(500)
        res.send('EROR_GET_ITEM')
    }
}

const update=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        res.status(500)
        res.send('EROR_GET_ITEM')
    }
}

const postItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        res.status(500)
        res.send('EROR_GET_ITEM')
    }
}

const deleteItem=(req:Request,res:Response)=>{
    try {
        
    } catch (error) {
        res.status(500)
        res.send('EROR_GET_ITEM')
    }
}

export {getItem,getItems,update,postItem,deleteItem}