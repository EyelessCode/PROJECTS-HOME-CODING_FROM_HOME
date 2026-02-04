import { Link } from "react-router-dom"

interface Props{
    loginLabel:string
    registerLabel:string
    loginLink:string
    registerLink:string
}

const NavBarSideItem_NoLogout = ({loginLink,registerLink,loginLabel,registerLabel}:Props) => {
    return (
        <>
            <p>
                <span className="hover:text-blue-600">
                    <Link to={loginLink}>{loginLabel}</Link></span>/
                <span className="hover:text-blue-600">
                    <Link to={registerLink}>{registerLabel}</Link></span>.
            </p>
        </>
    )
}

export default NavBarSideItem_NoLogout
