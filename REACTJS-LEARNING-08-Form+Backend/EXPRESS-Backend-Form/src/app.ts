import express from 'express'
import cors from 'cors'
import router from './routers/auth.routes'
import "dotenv/config"

const app=express()
app.use(cors())
app.use(express.json())
app.use("/myTy",router)

export default app
