import { InfoCharacter } from "../components/layout/InfoCharacter"
import { NavMenu } from "../components/layout/NavMenu"
import { SplashArt } from "../components/layout/SplashArt"

const Home = () => {
    return (
        <body className="text-black min-h-screen min-w-screen bg-[#ffdfb9]">
            <NavMenu/>
            <SplashArt/>
            <InfoCharacter/>
        </body>
    )
}

export {Home}
