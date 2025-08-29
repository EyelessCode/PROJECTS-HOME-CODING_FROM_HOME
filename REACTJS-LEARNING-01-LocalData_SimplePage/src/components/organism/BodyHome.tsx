import {
    SplashArt,InfoCharacter,Detail,
    characters,infoHome,detail,menuList
} from "../../global"

const BodyHome = () => {
    return (
        <main className="text-black min-h-[100dvh] min-w-[100dvw] bg-[#ffdfb9] flex flex-col">
            <SplashArt title="Zenless Zone Zero" url={infoHome.url} description={infoHome.description} />
            <InfoCharacter characterMini={characters} title="Most Famous Characters" />
            <Detail info={detail} title="About us" addressUrl={menuList[2].addressLink} />
        </main>
    )
}

export {BodyHome}
