import { useState } from "react";
import "./asserts/styles.css";
import axios from "axios";
import { useNavigate } from "react-router-dom";
export default function Login() {
    const [users, setUsers] = useState({
        userName: "",
        password: "",
    });
    const navigate = useNavigate();
    const handleSignUp = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/users/login", users);
            const data = response.data;
            if (response.status === 200 || response.status === 201) {
               navigate("/HomePage",{state:{user: data.User}})
            }
        } catch (err) {
            console.error("Registration failed:", err.message);
        }
    };

    return (
        <div className="mainContainer">
            <form onSubmit={handleSignUp}>
                <div>
                    <label htmlFor="userName">Username</label>
                    <input
                        type="text"
                        name="userName"
                        value={users.userName}
                        onChange={(e) => setUsers((p) => ({ ...p, userName: e.target.value }))}
                    />
                </div>
                <div>
                    <label htmlFor="password">Password</label>
                    <input
                        type="password"
                        name="password"
                        value={users.password}
                        onChange={(e) => setUsers((p) => ({ ...p, password: e.target.value }))}
                    />
                </div>
                <input type="submit" value="Submit" />
                <p className="form-footer" style={{ textAlign: "center" }}>
                    Already a user?{" "}
                    <a href="/Register" className="form-link" style={{ textDecoration: "none" }}>
                        Register in here
                    </a>
                </p>
            </form>
        </div>
    );
}
