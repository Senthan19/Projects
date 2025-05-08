import axios from "axios";
import { useState } from "react";
import { Link,useNavigate} from "react-router-dom";

export default function LoginPage() {
    const[loginCredentials, setLoginCredentials] = useState(
        {
            username:"",
            password:""
        }
    )
    const navigate = useNavigate();
    const[msg,setMsg] = useState("");
   
    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
        const res = await axios.post("http://localhost:8080/api/user/login",loginCredentials);
        if(res.data) {
           const data = res.data;
           if(data.role === "CUSTOMER") {
            localStorage.setItem("user",JSON.stringify(data));
                navigate("/Customer");
           } 
        }
        } catch(e) {
            setMsg(e);
        }
    }
    return(
        <div className="login">
            <form onSubmit={handleSubmit} className="formContainer">
                {msg && <p style={{textAlign:"center"}}>{msg}</p>}
                <label htmlFor="username">USERNAME:</label>
                <input type="text" id = "username" value={loginCredentials.username} onChange={(e) => setLoginCredentials(p => ({...p,username:e.target.value}))}/>
                <label htmlFor="password">PASSWORD:</label>
                <input id="password" style={{marginBottom:"0.5rem"}}type="password" value={loginCredentials.password} onChange={(e) => setLoginCredentials(p => ({...p,password:e.target.value}))}/>
                <input type="submit" value="submit"/>
                <p style={{textAlign:"center"}}>New User?{" "}<Link to="register">Register Here</Link></p>
            </form>
        </div>
    )
}