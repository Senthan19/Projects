import { useState } from "react";
import "./asserts/styles.css";
import axios from "axios";

export default function Register() {
    const [users, setUsers] = useState({
        userName: "",
        emailId: "",
        password: "",
    });

    const handleSignUp = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/users/register", users);
            if (response.status === 200 || response.status === 201) {
                window.location.href = "/";
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
                    <label htmlFor="emailId">Email Id</label>
                    <input
                        type="email"
                        name="emailId"
                        value={users.emailId}
                        onChange={(e) => setUsers((p) => ({ ...p, emailId: e.target.value }))}
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
                    <a href="/" className="form-link" style={{ textDecoration: "none" }}>
                        Log in here
                    </a>
                </p>
            </form>
        </div>
    );
}
