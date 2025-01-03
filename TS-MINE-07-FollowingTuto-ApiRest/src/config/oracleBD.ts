import "dotenv/config"
import { connect } from "http2"
import { Pool } from "pg"
// import {Pool} from 'pg'

/* const pool=new Pool({
    user:process.env.DB_USER,
    host:process.env.DB_HOST,
    database:process.env.DB_NAME,
    password:process.env.DB_PASSWORD,
    port:Number(process.env.DB_PORT)
})

const testConnection=async()=>{
    try {
        const client=await pool.connect()
        console.log(`BD CONNECTED!`);
        client.release()
    } catch (error) {
        console.error(`Error connecting to the database: ${error}`);
        throw error
    }
}

testConnection() */

async function dbConnect():Promise<void> {
    // const DB_HOST=<string>process.env.DB_HOST4
    const pool=new Pool({
        host:process.env.DB_HOST
    })
    await pool.connect()
}

export default dbConnect