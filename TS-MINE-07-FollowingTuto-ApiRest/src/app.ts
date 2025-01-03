import "dotenv/config"
import express from 'express'
import cors from 'cors'
import { router } from "./router"

const PORT=process.env.PORT||4000
const app=express()
app.use(cors())
app.use(express.json())
app.use(router)

app.listen(PORT,()=>console.log(`Listenning in '${PORT}' PORT`))