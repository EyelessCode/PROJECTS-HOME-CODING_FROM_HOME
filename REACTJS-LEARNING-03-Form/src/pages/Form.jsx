import { useState } from "react"
import { useAuth } from "../contexts/AuthContext"


const Form = () => {
    const {logIn,register}=useAuth()

    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handleSubmit=(e)=>{
        e.preventDefault()
        setError("")

        try {
            register(username,password)
        } catch (err) {
            setError(err.message)
        }
    }
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Ingrese usuario" value={username} onChange={e=>setUsername(e.target.value)}/>
                <input type="text" placeholder="Ingrese contraseña" value={password} onChange={e=>setPassword(e.target.value)}/>
                <button type="submit">Acceder</button>
            </form>
            {error&&<p>{error}</p>}
        </div>
    )
}

export default Form
