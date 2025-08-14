import { InfoCharacter } from "../components/InfoCharacter"
import { SplashArt } from "../components/SplashArt"

const Home = () => {
    return (
        <div className="text-black min-h-screen min-w-screen bg-[#ffdfb9]">
            <h1>Hello World | This is <i>Home Page</i></h1>
            <SplashArt/>
            <InfoCharacter/>
        </div>
    )
}

export {Home}
