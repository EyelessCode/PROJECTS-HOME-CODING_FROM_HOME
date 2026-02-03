import Header from "../components/Header";
import HeaderUserState from "../components/users/HeaderUserState";
import { useAuth } from "../contexts/auth/AuthContext";

function HomeOut() {
    const {user,logout}=useAuth()
    return (
        <>
            <Header companyName="ResorcesEC" door={user?true:false} userbar={<HeaderUserState username={user?.username} logout={logout}/>} />
            <main>HomeOut</main>
        </>
    )
}

export default HomeOut
