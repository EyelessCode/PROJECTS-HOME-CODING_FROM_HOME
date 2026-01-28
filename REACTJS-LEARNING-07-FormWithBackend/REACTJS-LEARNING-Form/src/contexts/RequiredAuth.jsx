import { Navigate } from "react-router-dom"
import { useAuth } from "./AuthContext"
import { jwtDecode } from "jwt-decode"

const RequiredAuth = ({children}) => {
    const {token}=useAuth()
    if(!token)return <Navigate to="/login" replace/>

    return children
}

export default RequiredAuth
