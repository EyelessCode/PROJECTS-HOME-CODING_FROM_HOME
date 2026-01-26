import { useAuth } from "../auth/contexts/AuthContext"

const Admin = () => {
    const {user}=useAuth()
    return (
        <div>
            <p>Hola administrador {user.username}</p>
        </div>
    )
}

export default Admin
