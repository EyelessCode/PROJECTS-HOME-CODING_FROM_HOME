import { Navigate, Route, Routes } from 'react-router-dom'
import './App.css'
import Home from './pages/Home'
import RequiredAuth from './auth/RequiredAuth'
import Register from './pages/Register'
import Login from './pages/Login'

function App() {

  return (
    <Routes>
      <Route path='/' element={<RequiredAuth><Home/></RequiredAuth>}/>
      <Route path='/login' element={<Login/>}/>
      <Route path='/register' element={<Register/>}/>
      <Route path='*' element={<Navigate to="/login" replace/>}/>
    </Routes>
  )
}

export default App
