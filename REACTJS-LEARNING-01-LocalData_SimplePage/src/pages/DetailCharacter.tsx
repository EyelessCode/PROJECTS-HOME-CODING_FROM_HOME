import { InfoCharacter } from "../components/molecule/InfoCharacter"
import { Header } from "../components/organism/Header"
import { SplashArt } from "../components/molecule/SplashArt"

const DetailCharacter = () => {
    return (
        <div className="text-black min-h-screen min-w-[100dvw] bg-[#ffdfb9]">
            <Header/>
            <SplashArt/>
            <InfoCharacter/>
        </div>
    )
}

export {DetailCharacter}
