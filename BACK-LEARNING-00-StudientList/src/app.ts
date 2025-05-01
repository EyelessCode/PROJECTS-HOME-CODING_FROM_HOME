import express from "express";
import cors from 'cors';
import 'dotenv/config'
import { ruta } from "./routes";

const app=express()
const PORT=process.env.PORT||4000

app.use(cors())
app.use(express.json())

app.use("/test",ruta)

app.listen(PORT,()=>console.log(`=> http://localhost:${PORT}`))
