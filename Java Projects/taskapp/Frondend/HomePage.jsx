import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import axios from "axios";
import TaskList from "./TaskList"; // Import your TaskList component
import "./asserts/HomePage.css"; // CSS file
import AddTask from "./AddTask";

export default function HomePage() {
  const location = useLocation();
  const user = location.state?.user;

  const [activeTab, setActiveTab] = useState("tasklist");
  const [isEditable, setIsEditable] = useState(false);
  const [users, setUsers] = useState({
    id: user.id,
    userName: user.userName,
    emailId: user.emailId,
    password: user.password,
  });

  const handleEditClick = () => setIsEditable(true);

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post("http://localhost:8080/api/users/register", users);
      if (response.status === 200 || response.status === 201) {
        const data = response.data;
        user.userId = data.userId;
        user.userName = data.userName;
        user.emailId = data.emailId;
        window.alert("Profile Updated Successfully");
        setIsEditable(false);
      }
    } catch (err) {
      window.alert("Something went wrong");
    }
  };

  return (
    <div className="homepage-container">
      <div className="navbar">
        <div>
        <button onClick={() => setActiveTab("tasklist")} style={{marginRight:"10px"}}>Task List</button>
        <button onClick={() => setActiveTab("addTask")}>Add Task</button>
        </div>
        <div>
        <button onClick={() => setActiveTab("profile")}>Profile</button>
        <button style={{marginLeft:"5px"}}><a href="/" style={{textDecoration:"none",color:"black"}}>Logout</a></button>
        </div>
      </div>

      <div className="content">
        {activeTab === "addTask" && <AddTask id={users.id}/>}
        {activeTab === "tasklist" && <TaskList id={users.id}/>}
        {activeTab === "profile" && (
          <div className="profile-container">
           
            <form onSubmit={handleSubmit}>
            <p onClick={handleEditClick} className="edit-btn" style={{marginTop:0,textAlign:"right"}}>
              Edit
            </p>
              <label htmlFor="userid">USER ID</label>
              <input
                name="userid"
                value={users.id}
                onChange={(e) => setUsers((p) => ({ ...p, userId: e.target.value }))}
                disabled={!isEditable}
              />

              <label htmlFor="username">USERNAME</label>
              <input
                name="username"
                value={users.userName}
                onChange={(e) => setUsers((p) => ({ ...p, userName: e.target.value }))}
                disabled={!isEditable}
              />

              <label htmlFor="emailid">EMAIL ID</label>
              <input
                name="emailid"
                value={users.emailId}
                onChange={(e) => setUsers((p) => ({ ...p, emailId: e.target.value }))}
                disabled={!isEditable}
              />

              {isEditable && <input type="submit" value="Save" />}
            </form>
          </div>
        )}
      </div>
    </div>
  );
}
