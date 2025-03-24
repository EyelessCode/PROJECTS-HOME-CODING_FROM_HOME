const express=require('express')
const cors = require('cors');
const path = require('path');
require('dotenv').config()

const app=express()
const PORT=process.env.PORT||4100

app.use(express.json())
app.use(cors())
app.use(express.static(path.join(__dirname,"public"))) //? Coge la carpeta como estática

app.get("/portafolio",(req,res)=>{
    res.sendFile(path.join(__dirname),"view","index.html")
})

app.listen(PORT,()=>console.log(`ESUCHANDO EN ${PORT}`))
