import {BrowserRouter,Routes,Route} from 'react-router'
import { About } from '../pages/About'
import { Home } from '../pages/Home'
import { DetailCharacter } from '../pages/DetailCharacter'
import NotFoundPage from '../pages/NotFoundPage'

const PageRoutes = () => {
    return (
        <BrowserRouter>
            <Routes>
                <Route path='/' element={<Home/>}/>
                <Route path='/about' element={<About/>}/>
                <Route path='/characters' element={<DetailCharacter/>}/>
                <Route path='*' element={<NotFoundPage/>}/>
            </Routes>
        </BrowserRouter>
    )
}

export {PageRoutes}
