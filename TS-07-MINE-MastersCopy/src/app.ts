import express, { Request, Response } from 'express';
import RoutClient from './routes/client.routes';

const app=express();
const PORT=4000;

app.use(express.json())
app.get('/',(req: Request,res: Response)=>{
    res.send(`Hola tu putamadre!`);
});
app.use('/api',RoutClient)

app.listen(PORT,()=>console.log(`Your server was connected in the ${PORT} PORT!`))