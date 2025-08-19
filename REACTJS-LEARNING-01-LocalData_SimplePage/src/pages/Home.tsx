import { Detail } from "../components/molecule/Detail";
import { InfoCharacter } from "../components/molecule/InfoCharacter"
import { NavMenu } from "../components/molecule/NavMenu"
import { SplashArt } from "../components/molecule/SplashArt"
import { characters, infoHome } from '../data/InfoRequired';

const Home = () => {
    return (
        <body className="text-black min-h-screen min-w-screen bg-[#ffdfb9] flex flex-col">
            <NavMenu/>
            <SplashArt title="Zenless Zone Zero" url={infoHome.url} description={infoHome.description} />
            <InfoCharacter characterMini={characters} />
            <Detail/>
        </body>
    )
}

export {Home}
