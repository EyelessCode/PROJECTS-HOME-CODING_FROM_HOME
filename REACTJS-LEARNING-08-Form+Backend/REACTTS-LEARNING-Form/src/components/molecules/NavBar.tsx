import { Link } from "react-router-dom"

interface Props{
    name:string
    link:string
}

const NavBar = ({link,name}:Props) => {
    return (
        <li className="hover:text-blue-600"><Link to={link}>{name}</Link></li>
    )
}

export default NavBar
