const express=require('express')
const cors = require('cors');
const path = require('path');
require('dotenv').config()

const app=express()
const PORT=process.env.PORT||4100

const ENDPOINT_PORTAFOLIO="/portafolio"

app.use(express.json())
app.use(cors())
app.use(express.static(path.join(__dirname,'public'))) //? Coge la carpeta como estática

app.get(`${ENDPOINT_PORTAFOLIO}`,(req,res)=>{
    res.sendFile(path.join(__dirname,'view','index.html'))
})

app.listen(PORT,()=>{
    console.log(`ESCUCHANDO EN LA URL: localhost:${PORT}${ENDPOINT_PORTAFOLIO}`)
})
