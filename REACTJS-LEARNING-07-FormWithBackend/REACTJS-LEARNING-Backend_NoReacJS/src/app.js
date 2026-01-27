import express from 'express'
import cors from 'cors'
import router from './auth/auth.routes.js'

const app=express()
app.use(cors())
app.use(express.json())
app.use('/api/auth', router)

export default app
