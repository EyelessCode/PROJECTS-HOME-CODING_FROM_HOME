import { PrismaClient } from "@prisma/client"
import { Car } from '../interface/carInterface';

const prisma=new PrismaClient()

const insertItem=async(carDAta:{
    color:string
    gas:'gasoline'|'electric'
    year:number
    description:string
    price:number
})=>{
    try {
        const responseInsert=await prisma.Car.create({
            data:carDAta
        })

        return responseInsert
    } catch (error) {
        console.error(`Error to insert a Car!`,error);
        throw new Error(`It was not possible to insert a Car!`)
    }
}

export {insertItem}