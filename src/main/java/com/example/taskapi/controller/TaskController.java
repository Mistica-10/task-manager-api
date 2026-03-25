package com.example.taskapi.controller;
import com.example.taskapi.dto.ApiResponse;
import com.example.taskapi.model.Task;
import com.example.taskapi.model.TaskStatus;
import com.example.taskapi.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }
    //get all tasks
    @GetMapping
    public ApiResponse<List<Task>> getTasks(){
        return new ApiResponse<>("success","Tasks fetched successfully",taskService.getAllTasks());
    }
    //create task
    @PostMapping
    public ApiResponse<Task> createTask(@RequestBody Task task){
        return new ApiResponse<>("success","Tasks created successfully",taskService.createTask(task));
    }
    //get task by ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);
    }
    //update task
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody Task task){
        return taskService.updateTask(id,task);
    }
    //Delete task
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
    //filter task by status
    @GetMapping("/status/{status}")
    public List<Task>getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }
    //pagination
    @GetMapping("/page")
    public Page<Task>getTasks(Pageable pageable){
        return taskService.getTasks(pageable);
    }

}
