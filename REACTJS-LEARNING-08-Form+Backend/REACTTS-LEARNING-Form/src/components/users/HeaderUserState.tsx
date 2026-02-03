export interface Props{
    username:string|undefined
    logout:()=>void
    // token:string
}

const HeaderUserState = ({username,logout}:Props) => {
    return (
        <section>
            <article>{username}</article>
            <article><button type="button" onClick={logout}>Cerrar sesión</button></article>
        </section>
    )
}

export default HeaderUserState
