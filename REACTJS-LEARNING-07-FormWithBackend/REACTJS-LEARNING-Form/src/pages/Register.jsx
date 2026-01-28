import { Link, useNavigate } from "react-router-dom"
import { useAuth } from "../contexts/AuthContext"
import { useState } from "react"

const Register = () => {
    const {register}=useAuth()
    const navigate=useNavigate()
    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handlesubmit=async(e)=>{
        e.preventDefault()
        setError("")
        try {
            await register(username,password)
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
                <button type="submit">Registrarse</button>
            </form>
            {error&&<p>{error}</p>}
            <div>
                <p>Ya tienes cuenta? <Link to="/login">Accede</Link>.</p>
            </div>
        </div>
    )
}

export default Register
