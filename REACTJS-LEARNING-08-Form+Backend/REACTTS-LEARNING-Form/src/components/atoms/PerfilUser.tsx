import type { ReactNode } from "react"

interface Props{
    username:string|undefined
    role:string|undefined
    // logout:()=>void
    children:ReactNode
}

const PerfilUser = ({children,role,username}:Props) => {
    return (
        <>
            <article>
                <p>{username}</p>
                <p>[{role}]</p>
            </article>
            <div>{children}</div>
        </>
    )
}

export default PerfilUser
