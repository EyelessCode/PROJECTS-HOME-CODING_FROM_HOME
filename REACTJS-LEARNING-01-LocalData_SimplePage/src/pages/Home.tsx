
import {Helmet} from "react-helmet"
import { BodyHome } from "../components/organism/BodyHome"
import { Header, heroLogo, menuList } from "../global"

const Home = () => {
    return (
        <>
            <Helmet>
                <title>Wiki Home | Zenless Zone Zero</title>
            </Helmet>
            <Header endUrl={menuList} title={heroLogo.title} logoUrl={heroLogo.logoUrl} />
            <BodyHome/>
        </>
    )
}

export {Home}
