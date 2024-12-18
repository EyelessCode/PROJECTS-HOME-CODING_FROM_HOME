// alert(`Hola mundo puta perra`);
import express, {Response,Request} from 'express';

const app=express();
const PORT=4000;

app.use(express.json());
app.get('/',(req:Request,res:Response)=>{
    res.send("Hello World!");
});
app.listen(PORT,()=>console.log(`Server listening in PORT number: ${PORT}`))