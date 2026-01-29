import { Link } from "react-router-dom"

const MainPage = () => {
    return (
        <div>
            <p>Aquí no habrá nada. Sólo una página que no obliga login, y accesible.</p>
            <div>
                <p><Link to="/login">Ir al login</Link></p>
                <p><Link to="/register">Ir al register</Link></p>
            </div>
        </div>
    )
}

export default MainPage
