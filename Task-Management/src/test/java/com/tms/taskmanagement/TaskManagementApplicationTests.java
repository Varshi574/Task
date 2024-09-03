package com.tms.taskmanagement;

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

import com.tms.taskmanagement.dto.TaskDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskManagementApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private String getBaseUrl() {
        return "http://localhost:" + port + "/task/";
    }


    @Test
    void testGetAllTasksByPid() {
        ResponseEntity<List> response = restTemplate.getForEntity(getBaseUrl().concat("getalltasksbypid/{pid}"), List.class, 1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testGetAllTask() {
        ResponseEntity<List> response = restTemplate.getForEntity(getBaseUrl().concat("getalltask"), List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }
    
    
    
    

    
    
    
    
    
    
    
    
//    @Test
//    void testUpdateTask() throws ParseException {
//        TaskDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("gettask/{tid}"), TaskDTO.class, 4L).getBody();
//        assertNotNull(getResponse);
//        getResponse.setTaskName("Air Ways TicketBooking");
//
//        HttpHeaders headers = new HttpHeaders();
//        HttpEntity<TaskDTO> entity = new HttpEntity<>(getResponse, headers);
//
//        TaskDTO putResponse = restTemplate.exchange(getBaseUrl().concat("update/{id}"), HttpMethod.PUT, entity, TaskDTO.class, 4L).getBody();
//
//        assertEquals("Air Ways TicketBooking", putResponse.getTaskName());
//    }
//
//    @Test
//    void testUpdateTaskStatus() {
//        restTemplate.put(getBaseUrl().concat("updatetstatus/{uid}/{pid}/{taskid}/{tstatus}"), 20L, 1L, 3L, "completed");
//
//        TaskDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("gettask/{tid}"), TaskDTO.class, 2L).getBody();
//        assertEquals("completed", getResponse.getTaskStatus());
//    }
//
//    @Test
//    void testDeleteTask() {
//        ResponseEntity<Void> deleteResponse = restTemplate.exchange(
//            getBaseUrl().concat("delete/{id}"), HttpMethod.DELETE, null, Void.class, 3L);
//
//        assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
//        
//        ResponseEntity<TaskDTO> getResponse = restTemplate.getForEntity(getBaseUrl().concat("gettask/{tid}"), TaskDTO.class, 3L);
//        assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
//    }
}
