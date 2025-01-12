import express, { Request, Response } from 'express'
import 'dotenv/config'
import { fileURLToPath } from 'url'
import path from 'path'

//// const filename=fileURLToPath(import.meta.url)
//// const dirname=path.dirname(filename)

const app=express()
const PORT=process.env.PORT||4001

app.use(express.json())
// app.use(express.static('public/view'))
app.use(express.static(path.join(__dirname,'..','public')))

app.get('/vitalSign',(req:Request,res:Response)=>{
    res.sendFile(path.join(__dirname,'..','view','vitalSign.html'))
})

app.listen(PORT,()=>console.log(`SERVER LISTENING IN ${PORT}`))
