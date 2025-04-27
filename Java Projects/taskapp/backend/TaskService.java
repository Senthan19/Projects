package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Tasks;
import com.example.demo.Entity.Users;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Repository.UserRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository tasksRepository;
    
    @Autowired
    private UserRepository ur;

    public List<Tasks> getAllTasks(Integer userId) {
        return tasksRepository.findByUser_Id(userId);
    }

    public String createTask(Integer id,Tasks task) {
    	Users user = ur.findById(id).orElse(null);
    	if(user == null) {
    		return "no user is found";
    	}
    	task.setUser(user);
    	tasksRepository.save(task);
    	return "Task added Successfully";
    }
    
    public String deleteTask(Integer taskId) {
    	tasksRepository.deleteById(taskId);
    	return "Task Deleted";
    }
  
}
