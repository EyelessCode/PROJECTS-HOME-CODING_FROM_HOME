import express, { Request, Response } from "express";
import 'dotenv/config'
import cors from "cors"
import path from "path";

const app=express()
const PORT=process.env.PORT||2000

app.use(cors())
app.use(express.json())
app.use(express.static(path.join(__dirname, 'public')))

app.get("/travels",(req:Request,res:Response)=>{
    res.sendFile(path.join(__dirname, 'public', 'view', 'index.html'))
})

//! TEST
app.get("/grid-R",(req:Request,res:Response)=>{
    res.send("Hello World!")
})

app.listen(PORT,()=>console.log(`Escuchando en el puerto ${PORT}`))
