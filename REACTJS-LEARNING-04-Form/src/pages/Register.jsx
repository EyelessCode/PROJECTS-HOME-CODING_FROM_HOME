import { useNavigate } from "react-router-dom"
import { userAuth } from "../auth/contexts/AuthContext"

const Register = () => {
    const {register}=userAuth()
    const navigate=useNavigate()

    const handleRegister=()=>{
        register("user","1234")
        navigate("/")
    }
    return (
        <div>
            <h2>Registro</h2>
            <button onClick={handleRegister}>Registrarse</button>
        </div>
    )
}

export default Register
