import { userAuth } from "../auth/contexts/AuthContext"

const Home = () => {
    const {user,logout}=userAuth()
    return (
        <div>
            <h1>Home</h1>
            <p>Bienvenido {user.username}</p>
            <button onClick={logout}>Salir</button>
        </div>
    )
}

export default Home
