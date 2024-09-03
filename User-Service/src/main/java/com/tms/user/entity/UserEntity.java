package com.tms.user.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data @AllArgsConstructor @NoArgsConstructor
public class UserEntity 
{
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    @NotNull
    @Size(min = 3, max = 50)
    private String userName;

    @Column(nullable = false)
    @NotNull
    @Size(min = 6)
    private String password;
    
    @Column(nullable = false)
    @NotNull
    private String role;

    @Column(nullable = false, unique = true)
    @NotNull
    @Email(message = "must be in the form of a email")
    private String email;

    @Column(nullable = false)
    //@ValidPid
    private Long projectId; 

    @Column(nullable = false)
    private String taskStatus;
    
    @NotNull
    private Long taskId;

}
