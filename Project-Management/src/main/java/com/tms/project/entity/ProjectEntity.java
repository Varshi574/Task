package com.tms.project.entity;

import java.sql.Date;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "projects")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectId;

    @NotNull

    @Column(unique = true)
    private String projectName;

    @NotNull

    private String projectDescription; 

    @NotNull
    private String projectStatus;


    @NotNull
//  @PastOrPresent
    @Temporal(TemporalType.DATE)
    private Date projectStart; 

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date projectEnd;

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	public String getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}

	public Date getProjectStart() {
		return projectStart;
	}

	public void setProjectStart(Date projectStart) {
		this.projectStart = projectStart;
	}

	public Date getProjectEnd() {
		return projectEnd;
	}

	public void setProjectEnd(Date projectEnd) {
		this.projectEnd = projectEnd;
	}

	public ProjectEntity(Long projectId, @NotNull String projectName, @NotNull String projectDescription,
			@NotNull String projectStatus, @NotNull Date projectStart, @NotNull Date projectEnd) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectDescription = projectDescription;
		this.projectStatus = projectStatus;
		this.projectStart = projectStart;
		this.projectEnd = projectEnd;
	}

	public ProjectEntity() {
		super();
	}
}
