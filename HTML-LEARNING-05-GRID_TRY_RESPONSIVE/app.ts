import express, { Request, Response } from "express";
import 'dotenv'
import cors from "cors"

const app=express()
const PORT=process.env.PORT||2000

app.use(cors())
app.use(express.json())

app.get("/grid-R",(req:Request,res:Response)=>{
    res.send("Hello World!")
})

app.listen(PORT,()=>console.log(`Escuchando en el puerto ${PORT}`))
