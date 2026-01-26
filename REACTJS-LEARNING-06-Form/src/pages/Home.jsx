import { Link } from "react-router-dom"
import { useAuth } from "../auth/contexts/AuthContext"

const Home = () => {
    const {user,logOut}=useAuth()
    return (
        <div>
            <h1>Bienvenido {user.username}</h1>
            <h2>ROL: {user.role}</h2>
            {user.role==="admin"&&(
                <p><Link to="/admin">Ir al panel ADMIN</Link></p>
            )}
            <button onClick={logOut}>Cerrar sesión</button>
        </div>
    )
}

export default Home
