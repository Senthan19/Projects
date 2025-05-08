import { Route, BrowserRouter as Router, Routes } from "react-router-dom";
import RegistrationPage from "./Registration";
import LoginPage from "./Login";
import CustomerHomePage from "./CustomerHomePage";

export default function AppRoutes() {
    return(
        <Router>
            <Routes>
            <Route path="/register" element={<RegistrationPage/>}/>
            <Route path="/" element={<LoginPage/>}/>
            <Route path="/customer" element={<CustomerHomePage/>}/>
            </Routes>
        </Router>
    )
}