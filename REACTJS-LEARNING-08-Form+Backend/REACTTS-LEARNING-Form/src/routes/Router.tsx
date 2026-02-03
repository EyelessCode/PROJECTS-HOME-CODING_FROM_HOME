import { Route, Routes } from "react-router-dom"
import NotFound from "../pages/NotFound"
import Register from "../pages/Register"
import Home from "../pages/HomeIn"
import Login from "../pages/Login"
import HomeOut from "../pages/HomeOut"


const MyRouter = () => {
    return (
        <Routes>
            <Route element={<HomeOut/>} path="/myTy" index/>
            <Route element={<Login/>} path="/login"/>
            <Route element={<Home/>} path="/home" index/>
            <Route element={<Register/>} path="/register"/>
            <Route element={<NotFound/>} path="*"/>
        </Routes>
    )
}

export default MyRouter
