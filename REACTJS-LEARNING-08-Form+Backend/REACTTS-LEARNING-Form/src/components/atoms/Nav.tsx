import type { ReactNode } from "react"

interface Props{
    children:ReactNode
}

const Nav = ({children}:Props) => {
    return (
        <nav>{children}</nav>
    )
}

export default Nav
