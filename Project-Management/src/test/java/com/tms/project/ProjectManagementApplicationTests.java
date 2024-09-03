package com.tms.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tms.project.dto.ProjectDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjectManagementApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
    	
        return "http://localhost:" + port + "/project/";
    }

//    @Test
//    void testCreateProject() throws ParseException {
//        ProjectDTO projectdto = new ProjectDTO();
//        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//
//        projectdto.setProjectName("Task Management System 2");
//        projectdto.setProjectDescription("A system to manage tasks and projects");
//        projectdto.setProjectStatus("ongoing");
//        projectdto.setProjectStart(new Date(date.parse("2024-08-01").getTime()));
//        projectdto.setProjectEnd(new Date(date.parse("2024-12-31").getTime()));
//
//        ProjectDTO response = restTemplate.postForEntity(getBaseUrl().concat("create"), projectdto, ProjectDTO.class).getBody();
//
//        assertNotNull(response);
//        assertEquals("Task Management System 2", response.getProjectName());
//    }

    /*@Test
    void testGetProjectByPid() {
        ResponseEntity<ProjectDTO> response = restTemplate.getForEntity(getBaseUrl().concat("getproject/{pid}"), ProjectDTO.class, 2L);
        assertNotNull(response.getBody());
        assertEquals("TaskManagementSystem", response.getBody().getProjectName());
    }*/

    @Test
    void testGetAllProjects() {
        ResponseEntity<List> response = restTemplate.getForEntity(getBaseUrl().concat("getall"), List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetAllProjectTasks() {
        ResponseEntity<List> response = restTemplate.getForEntity(getBaseUrl().concat("getalltasks/{pid}"), List.class, 1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
//
//    @Test
//    void testUpdateProject() throws ParseException {
//        ProjectDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("getproject/{pid}"), ProjectDTO.class, 2L).getBody();
//        assertNotNull(getResponse);
//        getResponse.setProjectName("Updated Project Name");
//
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<ProjectDTO> entity = new HttpEntity<>(getResponse, headers);
//
//        ProjectDTO putResponse = restTemplate.exchange(getBaseUrl().concat("update/{pid}"), HttpMethod.PUT, entity, ProjectDTO.class, 2L).getBody();
//
//        assertEquals("Updated Project Name", putResponse.getProjectName());
//    }
//
//    @Test
//    void testDeleteProject() {
//        ResponseEntity<Void> deleteResponse = restTemplate.exchange(
//            getBaseUrl().concat("delete/{pid}"), HttpMethod.DELETE, null, Void.class, 1L);
//
//        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
//        
//        ResponseEntity<ProjectDTO> getResponse = restTemplate.getForEntity(getBaseUrl().concat("getproject/{pid}"), ProjectDTO.class, 1L);
//        assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
//    }
}
