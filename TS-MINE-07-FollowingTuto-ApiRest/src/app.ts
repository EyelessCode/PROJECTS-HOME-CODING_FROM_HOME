import "dotenv/config"
import express from 'express'
import cors from 'cors'
import { router } from "./router"
import dbPostgreSql from './config/postgreSql'

const PORT=process.env.PORT||4000
const app=express()
app.use(cors())
app.use(express.json())
app.use(router)
dbPostgreSql().then(()=>console.log(`Connection with 'App.ts' already!`))


app.listen(PORT,()=>console.log(`Listenning in '${PORT}' PORT`))