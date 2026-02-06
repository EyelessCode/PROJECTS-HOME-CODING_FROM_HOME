import { HomeOutTemplate, useAuth } from "@/index"

function HomeOut() {
    const {user,logout}=useAuth()
    return <HomeOutTemplate isUser={user?false:true} logout={logout} role={"user"}
        username={"CristhianG74"}/>
}

export default HomeOut
