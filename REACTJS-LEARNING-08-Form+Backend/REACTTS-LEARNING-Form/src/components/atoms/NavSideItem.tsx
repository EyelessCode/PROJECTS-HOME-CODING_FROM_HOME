import type { ReactNode } from "react"

interface Props{
    isActive:boolean
    children:ReactNode
    children2:ReactNode
}

const NavSideItem = ({children,children2,isActive}:Props) => {
    return (
        <section>
            {isActive?children:children2}
        </section>
    )
}

export default NavSideItem
