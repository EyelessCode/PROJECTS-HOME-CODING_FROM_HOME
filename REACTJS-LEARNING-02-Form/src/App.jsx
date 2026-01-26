import { useAuth } from './contexts/AuthContext'
import Form from './pages/Form'
import Home from './pages/Home'

function App() {
  const {user}=useAuth()
  return user?<Home />:<Form />
}

export default App
