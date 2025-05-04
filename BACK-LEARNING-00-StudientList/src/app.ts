import express, { NextFunction, Request, Response } from "express";
import cors from 'cors';
import 'dotenv/config'
import { ruta } from "./routes";

const app=express()
const PORT=process.env.PORT||4000

app.use(cors())
app.use(express.json())

// app.use("/test",ruta)
app.use(ruta)


app.use((err:unknown,req:Request,res:Response,next:NextFunction):any=>{
    if(err instanceof Error){
        console.error(err.stack);
        return res.status(500).json({
            message:err.message
        })
    }

    return res.status(500).json({
        message:`Algo salió mal!`
    })
})

app.listen(PORT,()=>console.log(`=> http://localhost:${PORT}`))
