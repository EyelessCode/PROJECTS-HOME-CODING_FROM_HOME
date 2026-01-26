import { useState } from "react"
import { useAuth } from "../auth/contexts/AuthContext"
import { Link, useNavigate } from "react-router-dom"

const Register = () => {
    const {register}=useAuth()
    const navigate=useNavigate()
    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handleSubmit=(e)=>{
        e.preventDefault()
        setError("")

        try {
            register(username,password)
            navigate("/home",{replace:true})
        } catch (err) {
            setError(err.message)
        }
    }

    const handleOnChangeUsername=(e)=>setUsername(e.target.value)
    const handleOnChangePassword=(e)=>setPassword(e.target.value)
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" value={username} onChange={handleOnChangeUsername} placeholder="Ingresar usuario"/>
                <input type="password" value={password} onChange={handleOnChangePassword} placeholder="Ingresar contraseña"/>
                <button type="submit">Registrarse</button>
            </form>
            {error&&<p>{error}</p>}
            <div>
                <p>Ya tienes <Link to="/login">cuenta</Link>?</p>
            </div>
        </div>
    )
}

export default Register
