import { InfoCharacter } from "../components/molecule/InfoCharacter"
import { NavMenu } from "../components/molecule/NavMenu"
import { SplashArt } from "../components/molecule/SplashArt"

const DetailCharacter = () => {
    return (
        <div className="text-black min-h-screen min-w-screen bg-[#ffdfb9]">
            <NavMenu/>
            <SplashArt/>
            <InfoCharacter/>
        </div>
    )
}

export {DetailCharacter}
