package com.tms.project.dto;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data @AllArgsConstructor @NoArgsConstructor
public class ProjectDTO 
{
    private Long projectId;

    @NotNull

    @Column(unique = true)
    private String projectName;

    @NotNull

    private String projectDescription; 

    @NotNull
    private String projectStatus;


    @NotNull
    @Temporal(TemporalType.DATE)
    private Date projectStart; 

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date projectEnd;

}
