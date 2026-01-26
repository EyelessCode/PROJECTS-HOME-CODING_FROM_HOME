import { Link, useNavigate } from "react-router-dom"
import { useAuth } from "../auth/contexts/AuthContext"
import { useState } from "react"

const Register = () => {
    const {register}=useAuth()
    const navigate=useNavigate()

    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handleSubmit=(e)=>{
        e.preventDefault()
        setError("")

        if(!username||!password){
            setError("Los campos son obligatorios")
            return
        }
        try {
            register(username,password)
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
                <button type="submit">Registrarse</button>
            </form>
            {error&&<p>{error}</p>}
            <p>Tienes cuenta? <Link to="/login">Inicia sesión</Link></p>
        </div>
    )
}

export default Register

