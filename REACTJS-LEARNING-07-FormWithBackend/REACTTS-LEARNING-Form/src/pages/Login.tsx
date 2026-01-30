import React, { useState } from "react"
import { Link } from "react-router-dom"
import { useAuth } from "../contexts/AuthContext"

const Login = () => {
    const {login}=useAuth()
    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handleSubmit=async(e:React.SubmitEvent)=>{
        e.preventDefault()
        setError("")

        try {
            await login(username,password)
        } catch (err:any) {
            setError(err.response?.data?.message || "Error inesperado")
        }
    }

    const handleChangeUsername=(e:React.ChangeEvent<HTMLInputElement>)=>setUsername(e.target.value)
    const handleChangePassword=(e:React.ChangeEvent<HTMLInputElement>)=>setPassword(e.target.value)
    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="text" value={username} onChange={handleChangeUsername}/>
                <input type="password" value={password} onChange={handleChangePassword}/>
                <button type="submit">Acceder</button>
            </form>
            {error&&<p>{error}</p>}
            <div>
                <p>¿No tienes cuenta? <Link to="/register">Regístrate</Link>!</p>
            </div>
        </div>
    )
}

export default Login
