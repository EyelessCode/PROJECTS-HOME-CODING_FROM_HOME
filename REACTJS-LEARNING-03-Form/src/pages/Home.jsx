import { useAuth } from '../contexts/AuthContext'

const Home = () => {
    const {user,logout}=useAuth()
    return (
        <div>
            <h1>Bienvenido {user.username}</h1>
            <button onClick={logout}>Cerrar sesión</button>
        </div>
    )
}

export default Home
