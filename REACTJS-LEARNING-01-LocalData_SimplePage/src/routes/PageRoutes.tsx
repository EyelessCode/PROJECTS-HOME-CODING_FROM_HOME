import {BrowserRouter,Routes,Route} from 'react-router'
import { About } from '../pages/About'
import { Home } from '../pages/Home'

const PageRoutes = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/about' element={<About/>}/>
            </Routes>
        </BrowserRouter>
    )
}

export {PageRoutes}
