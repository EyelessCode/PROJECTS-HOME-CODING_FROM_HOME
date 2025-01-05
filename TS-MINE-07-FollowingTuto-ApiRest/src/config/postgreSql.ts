import "dotenv/config"
import { Pool } from "pg"

/* async function dbConnect(): Promise<void> {
    const pool = new Pool({
        user: process.env.DB_USER,
        host: process.env.DB_HOST,
        database: process.env.DB_NAME,
        password: process.env.DB_PASSWORD,
        port: Number(process.env.DB_PORT),
    });

    try {
        const client = await pool.connect();
        console.log("BD CONNECTED!");
        client.release();
    } catch (error) {
        console.error(`Error connecting to the database:`);
        throw error;
    }
}

export default dbConnect; */

async function dbConnection():Promise<void>{
	const connect=new Pool({
		connectionString:process.env.DB_URI
	})
	
	try{
		const client=await connect.connect()
		console.log(`DB CONNECTED`)
		client.release()
	}catch(error){
		console.error(`Error to connect DB!`.toUpperCase())
		throw error
	}
}

export default dbConnection



/* async function dbConnect():Promise<void> {
    // const DB_HOST=<string>process.env.DB_HOST4
    const pool=new Pool({
        connectionString:process.env.DB_HOST
    })
    await pool.connect()
}

export default dbConnect */

/* async function dbConnect(): Promise<void> {
    const pool = new Pool({
        connectionString: process.env.DB_URI, // Usa la cadena de conexión completa
    });

    try {
        const client = await pool.connect();
        console.log("BD CONNECTED!");
        client.release();
    } catch (error) {
        console.error(`Error connecting to the database: ${error}`);
        throw error;
    }
}

export default dbConnect; */