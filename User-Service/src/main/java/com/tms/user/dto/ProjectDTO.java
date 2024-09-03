package com.tms.user.dto;

import java.sql.Date;

import com.tms.user.dto.ProjectDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
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
