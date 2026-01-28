import { jwtDecode } from "jwt-decode"
import { useAuth } from "../contexts/AuthContext"

const Home = () => {
    const {token,logOut}=useAuth()
    const decoded=jwtDecode(token)
    return (
        <div>
            <h1>Hola {decoded.username}</h1>
            <button onClick={logOut}>Cerrar sesión</button>
        </div>
    )
}

export default Home
