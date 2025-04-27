package com.example.demo.Controller;

import com.example.demo.Entity.Tasks;
import com.example.demo.Service.TaskService;
import com.example.demo.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService tasksService;
    
    @Autowired 
    private UserService us;

    @PostMapping("/createtask")
    public ResponseEntity<?> createTask(@RequestParam("id") Integer id,@RequestBody Tasks task) {
    	return ResponseEntity.ok(tasksService.createTask(id, task));
    }
    
    @GetMapping("/getTasks/{userId}")
    public ResponseEntity<List<Tasks>> getTasksByUser(@PathVariable Integer userId) {
        return ResponseEntity.ok(tasksService.getAllTasks(userId));
    }
    
    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Integer taskId) {
        return ResponseEntity.ok(tasksService.deleteTask(taskId));
    }

}

