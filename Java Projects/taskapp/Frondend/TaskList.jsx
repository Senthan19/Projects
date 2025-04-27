import axios from "axios";
import { useEffect, useState } from "react";
import "./asserts/TaskList.css";
export default function TaskList({ id }) {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    axios
      .get(`http://localhost:8080/api/tasks/getTasks/${id}`)
      .then((res) => setTasks(res.data))
      .catch((err) => window.alert("Error fetching tasks: " + err.message));
  }, [id]); // <-- Add dependency array to prevent multiple calls
  
  const deleteTask = async (e,id) => {
    e.preventDefault();
    try {
      const res = await axios.delete(`http://localhost:8080/api/tasks/delete/${id}`);
      if(res.status === 200  || res.status === 201) {
        window.alert(res.data);
        setTasks((prevTasks) => prevTasks.filter((task) => task.id !== id));
      }   
    }catch(err) {
      window.alert(err.message);
    }
  }
  return (
    <div className="task-list-container">
      {tasks && tasks.map((task) => (
        <div key={task.id} className="task-card">
          <p className="task-title">Title: {task.taskName}</p>
          <p className="task-description">Description: {task.taskDescription}</p>
          <p className="task-description">Start: {task.startDate}</p>
          <p className="task-description">End: {task.dueDate}</p>
          <button className="task-deletion" onClick={(e)=>deleteTask(e,task.id)}>Delete Task</button>
        </div>
      ))}
      {tasks.length === 0 && <h1>There is no Tasks Available</h1>}
    </div>
  );
  
}
