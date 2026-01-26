import { useAuth } from "../auth/contexts/AuthContext"

const Home = () => {
    const {user,logOut}=useAuth()
    return (
        <div>
            <h1>Bienvenido {user.username}</h1>
            <button onClick={logOut}>Cerrar sesión</button>
        </div>
    )
}

export default Home
