import { Route, Routes } from 'react-router-dom'
import './App.css'
import Login from './pages/Login'
import Register from './pages/Register'
import Home from './pages/Home'
import RequireAuth from './auth/RequireAuth'
import Unauthorized from './pages/Unauthorized'

function App() {

  return (
    <Routes>
      <Route path='/login' element={<Login/>} />
      <Route path='/register' element={<Register/>} />

      <Route path='/' element={<RequireAuth><Home/></RequireAuth>} />
      <Route path='/unauthorized' element={<Unauthorized/>} />
    </Routes>
  )
}

export default App
