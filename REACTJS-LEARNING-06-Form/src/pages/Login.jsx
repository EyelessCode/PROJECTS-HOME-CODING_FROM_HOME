import { useState } from "react"
import { useAuth } from "../auth/contexts/AuthContext"
import { Link, useNavigate } from "react-router-dom"

const Login = () => {
    const {login}=useAuth()
    const navegate=useNavigate()
    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")
    const handleSubmit=(e)=>{
        e.preventDefault()
        setError("")
        try {
            login(username,password)
            navegate("/home",{replace:true})
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
                <button type="submit">Acceder</button>
            </form>
            {error&&<p>{error}</p>}
            <div>
                <p>Quieres <Link to="/register">registrarte</Link>?</p>
            </div>
        </div>
    )
}

export default Login
