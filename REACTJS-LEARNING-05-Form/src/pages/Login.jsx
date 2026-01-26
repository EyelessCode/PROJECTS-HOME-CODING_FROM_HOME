import { useState } from "react"
import { useAuth } from "../auth/contexts/AuthContext"
import { Link, useNavigate } from "react-router-dom"

const Login = () => {
    const {login}=useAuth()
    const navigate=useNavigate()

    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handleSubmit=(e)=>{
        e.preventDefault()
        setError("")

        try {
            login(username,password)
            navigate("/",{replace:true}) // NO puedes regresar de pág.
        } catch (err) {
            setError(err.message)
        }
    }

    const handleUsername=(e)=>setUsername(e.target.value)
    const handlePassword=(e)=>setPassword(e.target.value)

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Ingresa usuario" value={username} onChange={handleUsername}/>
                <input type="password" placeholder="Ingresa contraseña" value={password} onChange={handlePassword}/>
                <button type="submit">Acceder</button>
            </form>
            {error&&<p>{error}</p>}
            <p>No tienes cuenta? <Link to="/register">Regístrate</Link></p>
        </div>
    )
}

export default Login
