import { Link } from "react-router-dom"

interface Props{
    name:string
    link:string
}

const NavItems = ({link,name}:Props) => {
    return (
        <li className="hover:text-blue-600 text-2xl mx-4"><Link to={link}>{name}</Link></li>
    )
}

export default NavItems
