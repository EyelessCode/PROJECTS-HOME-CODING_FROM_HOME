import express, { Request, Response } from 'express';

const app=express();
const PORT=4000;

app.use(express.json())
app.get('/api',(req: Request,res: Response)=>{
    res.send(`Hola tu putamadre!`);
});

app.listen(PORT,()=>console.log(`Your server was connected in the ${PORT} PORT!`))