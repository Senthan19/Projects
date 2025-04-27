import { useState } from "react";
import "./asserts/AddTask.css";
import axios from "axios";
export default function AddTask({id}) {
    const[task,setTasks] = useState( {
        taskName:"",
        taskDescription:"",
        startDate:"",
        dueDate:""
        }
    )
    const addTask = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post(`http://localhost:8080/api/tasks/createtask?id=${id}`,task);
            if(response.status === 200 || response.status === 201) {
                window.alert(response.data);
                task.taskName = "";
                task.taskDescription = "";
                task.startDate = "";
                task.dueDate = "";
            }
        } catch(err) {
            window.alert(Response.data);
        }
    }
    return(
        <div className="main-container">
            <div className="form-container">
                <form onSubmit={addTask}>
                    <label htmlFor="taskname">TaskName</label>
                    <input type="text" name="taskname" value={task.taskName} onChange={e => setTasks(p=>({...p,taskName:e.target.value}))}/>
                    <label htmlFor="desc">TaskDecription</label>
                    <textarea cols={5} rows={5} name="desc" onChange={e =>setTasks(p=>({...p,taskDescription:e.target.value}))}/>
                    <label htmlFor="sdate">Start Date</label>
                    <input type="text" name="sdate" onChange={e => setTasks(p => ({...p,startDate:e.target.value}))}/>
                    <label htmlFor="Ddate">Due Date</label>
                    <input type="text" name="Ddate" onChange={e => setTasks(p => ({...p,dueDate:e.target.value}))}/>
                    <input type="submit"/>
                </form>
            </div>
        </div>
    )
}