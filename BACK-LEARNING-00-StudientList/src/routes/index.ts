import { Router } from "express";
import { readdirSync } from "fs";

const ruta=Router()
const PATH=`${__dirname}`

const cortar=(file:string)=>{
    const cortarFile=file.split('.').shift()
    return cortarFile
}

readdirSync(PATH).filter((file)=>{
    const clean=cortar(file)

    if (clean!=='index') {
        import (`./${clean}`).then((modulo)=>{
            console.log(`Ruta: ${clean}`);
            ruta.use(`/router-${clean}`,modulo.ruta)
        })
    }
})

export {ruta}
