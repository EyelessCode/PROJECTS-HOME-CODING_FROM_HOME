
const url='http://localhost:4000'
const API='/api/vitalSign.html'

async function connection() {
    try {
        const response=await fetch(url+API)
        if (!response) {
            throw new Error(`HTTP ERROR STATUS!: ${response.status}`)
        }

        const user=await response.json()
        console.log();
        return user
    } catch (error) {
        console.error(`ERROR: `+error);
        throw error
    }
}
