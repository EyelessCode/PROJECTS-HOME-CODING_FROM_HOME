import { Navigate } from "react-router-dom"
import { useAuth } from "./contexts/AuthContext"

const RequiredRole = ({role,children}) => {
    const {user}=useAuth()
    if(!user||user.role!==role)return <Navigate to="/" replace/>
    return children
}

export default RequiredRole
