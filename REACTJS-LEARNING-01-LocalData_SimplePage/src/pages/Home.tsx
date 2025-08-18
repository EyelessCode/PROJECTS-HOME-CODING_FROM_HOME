import { InfoCharacter } from "../components/layout/InfoCharacter"
import { NavMenu } from "../components/layout/NavMenu"
import { SplashArt } from "../components/layout/SplashArt"
import { characters, infoHome } from '../data/InfoRequired';

const Home = () => {
    return (
        <body className="text-black min-h-screen min-w-screen bg-[#ffdfb9] flex flex-col">
            <NavMenu/>
            <SplashArt title="Zenless Zone Zero" url={infoHome.url} description={infoHome.description} />
            <InfoCharacter characterMini={characters} />
        </body>
    )
}

export {Home}
