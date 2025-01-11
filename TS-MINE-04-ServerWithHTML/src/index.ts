import express,{response,request} from 'express';

const app=express();
const PORT:number=4010;

app.use(express.static('public'));

app.listen(PORT,()=>console.log(`Listening server in: ${PORT}`));