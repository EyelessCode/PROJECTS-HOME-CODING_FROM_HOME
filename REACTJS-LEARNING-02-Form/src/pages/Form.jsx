import { useState } from "react"
import { useAuth } from "../contexts/AuthContext"

const Form = () => {
    const {form}=useAuth()

    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handleSubmit=(e)=>{
        e.preventDefault()
        setError("")

        try {
            form(username,password)
        } catch (err) {
            setError(err.message)
        }
    }
    return (
        <div>
            <h2>Login/Register</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="usuario" value={username} onChange={e=>setUsername(e.target.value)} />
                <input type="text" placeholder="password" value={password} onChange={e=>setPassword(e.target.value)} />
                <button type="submit">Acceder</button>
            </form>
            {error&&<p style={{color:"red"}}>{error}</p>}
        </div>
    )
}

export default Form
