package com.example.taskapi.service;
import com.example.taskapi.model.Task;
import com.example.taskapi.model.TaskStatus;
import com.example.taskapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
@Service

public class TaskService {
    private final TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    //get all tasks
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }
    //create new task
    public Task createTask(Task task){
        return taskRepository.save(task);
    }
    //get task by ID
    public Task getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
    }
    //Delete task
    public void deleteTask(Long id){
        taskRepository.deleteById(id);
    }
    //update task
    public Task updateTask(Long id,Task updatedTask){
        Task task = taskRepository.findById(id).orElse(null);
        if (task !=null){
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(task);
        }
        return null;
    }
    //find task by status
    public List<Task>getTasksByStatus(TaskStatus status){
        return taskRepository.findByStatus(status);
    }
    //pagination
    public Page<Task> getTasks(Pageable pageable){
        return taskRepository.findAll(pageable);
    }
}

