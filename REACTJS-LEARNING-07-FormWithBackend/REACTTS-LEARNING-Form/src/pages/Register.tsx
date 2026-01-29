import { Link, useNavigate } from "react-router-dom"
import { useAuth } from "../contexts/AuthContext"
import { useState } from "react"

const Register = () => {
    const navigate=useNavigate()
    const {register}=useAuth()
    const [username,setUsername]=useState("")
    const [password,setPassword]=useState("")
    const [error,setError]=useState("")

    const handleSubmit=async(e:React.SubmitEvent)=>{
        e.preventDefault()
        setError("")

        try {
            await register(username,password)
            navigate("/user")
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
                <button type="submit">Registrarse</button>
            </form>
            {error&&<p>{error}</p>}
            <div>
                <p>Ya tienes cuenta? <Link to="/login">inicia sesión</Link>!</p>
            </div>
        </div>
    )
}

export default Register
