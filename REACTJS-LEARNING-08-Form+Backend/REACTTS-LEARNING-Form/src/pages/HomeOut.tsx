import { HomeOutTemplate, useAuth } from "@/index"

function HomeOut() {
    const {user,logout}=useAuth()
    return <HomeOutTemplate img="@/../public/grafico_barras.webp" imgAlt="Gráfico de barras" isUser={user?true:false} logout={logout} role={"user"}
        username={"CristhianG74"}/>
}

export default HomeOut
