package com.example.taskapi.repository;
import com.example.taskapi.model.Task;
import com.example.taskapi.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByStatus(TaskStatus status);//spring data JPA auto generates SQL for this.
}
