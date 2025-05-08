import { useState } from "react";
import axios from "axios";
import "./asserts/Profile.css";

export default function Profile({setActiveTab}) {
    const [user, setUser] = useState(JSON.parse(localStorage.getItem("user")));
    const [editable, setEditable] = useState(true);
    const [address, setAddress] = useState(JSON.parse(localStorage.getItem("address")));
    const [display, setDisplay] = useState("none");

    const displayAddress = () => {
        setDisplay(prev => prev === "none" ? "block" : "none");
    };

    const userUpdate = async () => {
        try {
        const res = await axios.post("http://localhost:8080/api/user/update", user);
        if(res.data) {
            localStorage.setItem("user",JSON.stringify(res.data));
            setUser(res.data);
        }
        }catch(e) {
            console.log(e);
        }
        setEditable(!editable);
    }
    
    const updateAddress = async () => {
        try {
        const res = await axios.post("http://localhost:8080/api/address/update", address);
        if(res.data) {
            localStorage.setItem("address",JSON.stringify(res.data));
            setAddress(res.data);
        }
        }catch(e) {
            console.log(e);
        }
        setEditable(!editable);
    }
    return (
        <div className="profile-container">
            <p style={{ float: "right", cursor: "pointer" }} onClick={() => setEditable(!editable)}>Edit</p>

            <form className="form-container">
                <label htmlFor="username">USERNAME: </label>
                <input
                    type="text"
                    value={user.username}
                    onChange={(e) => setUser(p => ({ ...p, username: e.target.value }))}
                    disabled={editable}
                />

                <label htmlFor="emailid">EMAIL ID</label>
                <input
                    type="email"
                    value={user.emailId}
                    onChange={(e) => setUser(p => ({ ...p, emailId: e.target.value }))}
                    disabled={editable}
                />
            </form>

            <p onClick={() => setActiveTab("Order")} 
            style={{
                cursor:"pointer",
                fontWeight:"bold"
            }}
            >Show My Orders</p>

            <div>
                <form>
                    <label htmlFor="address" onClick={displayAddress} style={{ cursor: "pointer" }}>
                        SAVED ADDRESS
                    </label>

                    {display === "block" && (
                        <div>
                            <p style={{ float: "right", cursor: "pointer" }} onClick={() => setEditable(!editable)}>Edit</p>
                            <textarea
                                value={address.address ? address.address: ""}
                                onChange={(e) => setAddress(p => ({...p,address:e.target.value}))}
                                disabled={editable}
                                style={{ display: display }}  
                            />
                             {!editable && <div style={{float:"right",display:"flex",marginTop:"5px"}}>
                                <button onClick={()=>updateAddress()}>SAVE</button>
                                <button>DELETE</button>
                                </div>
                            }
                        </div>
                    )}
                </form>
            </div>
            <button style={{marginTop:"5px"}}><a href="/">LOG OUT</a></button>
            {!editable && <button style={{marginTop:"20px"}} onClick={()=>userUpdate()}>SAVE</button>}
        </div>
    );
}
