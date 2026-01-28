import { Navigate, Route, Routes } from "react-router-dom"
import Admin from "../pages/Admin"
import MainPage from "../pages/MainPage"
import Register from "../pages/Register"
import Login from "../pages/Login"
import Home from '../pages/Home';
import RequiredAuth from "./guards/RequiredAuth"
import RequiredRole from "./guards/RequiredRole"

const Router = () => {
    return (
        <Routes>
            <Route path="/admin" element={<RequiredRole role="admin"><Admin/></RequiredRole>}/>
            <Route path="/register" element={<Register/>}/>
            <Route path="/login" element={<Login/>}/>
            <Route path="/user" element={<RequiredAuth><Home/></RequiredAuth>}/>
            <Route path="/" element={<MainPage/>}/>
            <Route path="*" element={<Navigate to="/" replace/>}/>
        </Routes>
    )
}

export default Router
