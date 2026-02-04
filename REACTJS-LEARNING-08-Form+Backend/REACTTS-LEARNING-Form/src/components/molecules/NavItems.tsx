import NavSideItem from "../atoms/NavSideItem"
import NavBarSideItem_Logout from '../atoms/NavBarSideItem_Logout';
import NavBarSideItem_NoLogout from "../atoms/NavBarSideItem_NoLogout";

interface Props{
    username:string|undefined
    isActive:boolean
    logout:()=>void
    logoutLabel:string
    loginLabel:string
    registerLabel:string
    loginLink:string
    registerLink:string
}

const NavItems = ({isActive,logout,logoutLabel,username,
    loginLabel,loginLink,registerLabel,registerLink}:Props) => {
    return (
        <NavSideItem isActive={isActive}
            children={<NavBarSideItem_Logout
                logoutLabel={logoutLabel} logout={logout} username={username}/>}
            children2={<NavBarSideItem_NoLogout
                loginLabel={loginLabel} registerLabel={registerLabel}
                loginLink={loginLink} registerLink={registerLink}/>}
        />
    )
}

export default NavItems
