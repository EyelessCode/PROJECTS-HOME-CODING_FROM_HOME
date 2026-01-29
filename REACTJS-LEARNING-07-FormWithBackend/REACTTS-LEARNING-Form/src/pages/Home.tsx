import { useAuth } from "../contexts/AuthContext"

const Home = () => {
    const {user,logout}=useAuth()
    return (
        <div>
            <div>
                <span>{user?.username}</span>
                <p>{user?.role}</p>
                <button onClick={logout} type="button">Cerrar sesión</button>
            </div>
            <div>
                <h1>Bienvenido {user?.username}</h1>
            </div>
        </div>
    )
}

export default Home
