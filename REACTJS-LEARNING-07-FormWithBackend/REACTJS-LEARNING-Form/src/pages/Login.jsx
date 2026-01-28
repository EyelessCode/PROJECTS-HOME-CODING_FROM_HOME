import { useState } from "react"
import { useAuth } from "../contexts/AuthContext"
import { Link, useNavigate } from "react-router-dom"

const Login = () => {
    const {login}=useAuth()
    const navigate=useNavigate()
    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")
    
    const handlesubmit=async(e)=>{
        e.preventDefault()
        setError("")
        try {
            await login(username,password)
            navigate("/home")
        } catch (err) {
            setError(err.message)
        }
    }

    const handleUsernameChange=(e)=>setUsername(e.target.value)
    const handlePasswordChange=(e)=>setPassword(e.target.value)
    return (
        <div>
            <form onSubmit={handlesubmit}>
                <input type="text" placeholder="Ingresar usuario" value={username} onChange={handleUsernameChange}/>
                <input type="password" placeholder="Ingresar contraseña" value={password} onChange={handlePasswordChange}/>
                <button type="submit">Acceder</button>
            </form>
            {error&&<p>{error}</p>}
            <div>
                <p>¿No tienes cuenta? <Link to="/register">Regístrate</Link>.</p>
            </div>
        </div>
    )
}

export default Login
