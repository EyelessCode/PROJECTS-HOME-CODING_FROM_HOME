import { useNavigate } from "react-router-dom"
import { userAuth } from "../auth/contexts/AuthContext"

const Login = () => {
    const {login}=userAuth()
    const navigate=useNavigate()

    const handleLogin=()=>{
        login("user","1234")
        navigate("/")
    }
    return (
        <div>
            <h2>Login</h2>
            <button onClick={handleLogin}>Acceder</button>
        </div>
    )
}

export default Login
