package com.example.taskapi.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

import java.time.LocalDate;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    @NotBlank(message ="Title cannot be empty")
    private String title;
    @NotBlank(message ="Description cannot be empty")
    private String description;
    @NotNull(message ="Status is required")
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @NotNull(message = "Due date is required")
    private LocalDate dueDate;
    public Task(){}
    public long getId(){
        return id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public TaskStatus getStatus(){
        return status;
    }
    public void setStatus(TaskStatus status){
        this.status=status;
    }
    public LocalDate getDueDate(){
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate){
        this.dueDate=dueDate;
    }
}
