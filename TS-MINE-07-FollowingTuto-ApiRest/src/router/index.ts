import { Router } from "express";
import { readdirSync } from "node:fs";

const PATH_ROUTER=`${__dirname}`
const router=Router()

const cleanFileName=(fileName:string)=>{
    const file=fileName.split(".").shift()
    return file
}

readdirSync(PATH_ROUTER).filter((filename)=>{
    const cleanName=cleanFileName(filename)
    if (cleanName!=="index") {
        import(`./${cleanName}`).then((moduleRouter)=>{
            console.log(`It's working: /${cleanName}`);
            router.use(`/${cleanName}`,moduleRouter.router)
        })
    }
})


export {router}