import { useState } from "react"
import { Link, useNavigate } from "react-router-dom";
import "./asserts/Register_LoginStyle.css";
import axios from "axios";
export default function RegistrationPage() {
    const[user, setUser] = useState({
        username:"",
        emailId:"",
        password:"",
        role:""
    });
    const navigate = useNavigate();
    const handleSubmit = async (e) => {
        e.preventDefault(); // prevent default form submission behavior
        try {
            const response = await axios.post("http://localhost:8080/api/user/register", user);
            if (response.status === 200) {
                console.log(response.data);
                setUser({
                    username: "",
                    emailId: "",
                    password: "",
                    role: ""
                });
                console.log(user);
                navigate("/");
            }
        } catch (e) {
            console.log(e);
        }
    }
    


    return(
        <div className="register">
            <form onSubmit={handleSubmit} className="formContainer">
                <label htmlFor="username">USERNAME:</label>
                <input type="text" id = "username" value={user.username} onChange={(e) => setUser(p => ({...p,username:e.target.value}))}/>
                <label htmlFor="emailid">EMAIL ID:</label>
                <input id="emailid" type="email" value={user.emailId} onChange={(e) => setUser(p => ({...p,emailId:e.target.value}))}/>
                <label htmlFor="password">PASSWORD:</label>
                <input id="password" type="password" value={user.password} onChange={(e) => setUser(p => ({...p,password:e.target.value}))}/>
                <label htmlFor="role">ROLE:</label>
                <select 
                    id="role" 
                    value={user.role} 
                    onChange={(e) => setUser(p => ({ ...p, role: e.target.value }))}>
                    <option value="">SELECT ROLE</option>
                    <option value="CUSTOMER">CUSTOMER</option>
                    <option value="ADMIN">ADMIN</option>
                </select>
                <input type="submit" value="submit"/>
                <p style={{textAlign:"center"}}>Already Register?{" "}<Link to="/">Login Here</Link></p>
            </form>
        </div>
    )
}