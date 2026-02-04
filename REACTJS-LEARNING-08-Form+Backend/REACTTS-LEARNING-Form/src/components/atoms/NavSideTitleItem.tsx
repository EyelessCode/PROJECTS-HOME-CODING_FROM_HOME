interface Props{
    title:string
}

const NavSideTitleItem = ({title}:Props) => {
    return (
        <article>
            <h1 className="text-6xl">
                {/* <span className="text-gray-600 bg-indigo-300 rounded-2xl">Resorcer</span>
                <span className="text-yellow-300">EC</span> */}
                {title}
            </h1>
        </article>
    )
}

export default NavSideTitleItem
