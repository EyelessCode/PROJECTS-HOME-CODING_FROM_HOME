import { Navigate, Route, Routes } from "react-router-dom"
import Login from "../pages/Login"
import Register from "../pages/Register"
import RequiredAuth from "../auth/RequiredAuth"
import Home from "../pages/Home"
import RequiredRole from "../auth/RequiredRole"
import Admin from "../pages/Admin"

const RouterPages = () => {
    return (
        <Routes>
            <Route path="/login" element={<Login/>}/>
            <Route path="/register" element={<Register/>}/>
            <Route path="/home" element={<RequiredAuth><Home/></RequiredAuth>}/>
            <Route path="/admin" element={<RequiredRole role="admin"><Admin/></RequiredRole>}/>
            <Route path="*" element={<Navigate to="/login" replace/>}/>
        </Routes>
    )
}

export default RouterPages
