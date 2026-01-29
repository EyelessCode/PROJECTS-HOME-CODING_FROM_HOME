import { useAuth } from "../contexts/AuthContext"

const Admin = () => {
    const {user,logout}=useAuth()
    
    return (
        <div>
            <div>
                <span>{user?.username}</span>
                <p>{user?.role}</p>
                <button type="button" onClick={logout}>Cerrar sesión</button>
            </div>
            <div><h1>Bienvenido al sitio administrador, {user?.username}</h1></div>
        </div>
    )
}

export default Admin
