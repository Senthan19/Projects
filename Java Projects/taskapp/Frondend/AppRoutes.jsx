import {Routes,Route} from "react-router-dom";
import Login from "./Login";
import Register from "./RegisterPage";
import HomePage from "./HomePage";

export default function AppRoute() {
    return(
        <Routes>
            <Route path="/" element={<Login/>}/>
            <Route path="/Register" element={<Register/>}/>
            <Route path="/HomePage" element={<HomePage/>}/>
        </Routes>
    )
}