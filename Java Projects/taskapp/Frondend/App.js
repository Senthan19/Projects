import { BrowserRouter } from "react-router-dom";
import AppRoute from "./AppRoutes";

export default function App() {
    return (
        <BrowserRouter>
        <AppRoute/>
        </BrowserRouter>
    );
}