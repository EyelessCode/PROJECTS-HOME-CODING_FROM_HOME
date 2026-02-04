import { Nav } from '../organisms/home/out/Nav';

const Header = () => {
    // door=false

    return (
        <header className="flex justify-between px-4 py-3 items-center text-2xl bg-indigo-200 rounded-b-3xl">
            <Nav title="ResorcesEC"/>
            {/* <article>
                <h1 className="text-6xl hover:text-amber-300">
                    <span className="text-gray-600 bg-indigo-300 rounded-2xl">Resorcer</span>
                    <span className="text-yellow-300">EC</span>
                </h1>
            </article>
            <div>
                <nav>
                    <ul className="flex flex-row justify-center gap-7">
                        {navItem.map((element,i:number):JSX.Element=>{
                            return (
                                <li key={i} className="hover:text-blue-600 bg-indigo-300 p-2 rounded-full">
                                    <Link to={element.link}>{element.name}</Link>
                                </li>
                            )
                        })}
                    </ul>
                </nav>
            </div> */}
            {/* <HeaderUserState isActive={user?true:false} username={user?.username} logout={logout}/> */}
        </header>
    )
}

export default Header
