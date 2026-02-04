interface Props{
    username:string|undefined
    logout:()=>void
    logoutLabel:string
}

const NavBarSideItem_Logout = ({logoutLabel,logout,username}:Props) => {
    return (
        <>
            <article>
                <span>{username}</span>
            </article>
            <article><button type="button" onClick={logout}>{logoutLabel}</button></article>
        </>
    )
}

export default NavBarSideItem_Logout
