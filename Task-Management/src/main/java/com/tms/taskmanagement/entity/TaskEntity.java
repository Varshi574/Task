package com.tms.taskmanagement.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tasks")
@Data @NoArgsConstructor @AllArgsConstructor
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;

    @NotNull
    @Size(min = 5, max = 100)
    private String taskName; 

    @NotNull
    @Size(min = 10)
    private String taskDescription; 
    
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date taskStart;
    
    @NotNull
    private Long taskId;

    @NotNull
    private String taskStatus; 

    @NotNull
    private Long projectId; 

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date taskEnd;
    
    
    @NotNull
    private Long userId;
}
