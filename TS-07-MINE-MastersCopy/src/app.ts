import express, { request, Request, Response } from 'express';
import RoutClient from './routes/client.routes';
import path from 'path';

const app=express();
const PORT=4000;

app.use(express.json())
app.get('/',(req: Request,res: Response)=>{
    // res.send(`Hola tu putamadre!`);
    res.sendFile(path.join(__dirname,'../public/index.html'))
});

app.get('/client',(req:Request,res:Response)=>{
    res.sendFile(path.join(__dirname,'../public/getIndex.html'))
})

app.use('/api',RoutClient)


app.listen(PORT,()=>console.log(`Your server was connected in the ${PORT} PORT!`))