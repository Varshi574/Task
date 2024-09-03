package com.tms.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import com.tms.user.dto.UserDTO;
import com.tms.user.dto.UserLoginDTO;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceApplicationTests {
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	private String getBaseUrl() {
		return "http://localhost:" + port + "/user/";
	}

	@Test
	@DisplayName("testing create method")
	void testCreateUser() {
		UserLoginDTO userdto = new UserLoginDTO( "Ned Stark", "Ned@123", "Ned@gmail.com");
		UserLoginDTO response = restTemplate
				.postForEntity(getBaseUrl().concat("createuser"), userdto, UserLoginDTO.class).getBody();

		assertNotNull(response);
		//assertEquals("Ned Stark", response.getUserName());
	}

	@Test
	void testGetUser()
	{
		UserDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("getuser/{id}"), UserDTO.class,1).getBody();
		
		assertEquals("varshitha", getResponse.getUserName());
		//assertNotNull(getResponse);
	}

	@Test
	void testUpdateUser()
	{
		UserDTO getResponse = restTemplate.getForEntity(getBaseUrl().concat("getuser/{id}"), UserDTO.class,2).getBody();
		getResponse.setUserName("Bhuvana");
		
		//restTemplate.put(getBaseUrl().concat("update/{uid}"), getResponse,UserDTO.class, 2);
		
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<UserDTO> entity = new HttpEntity<UserDTO>(getResponse,headers);
		
		UserDTO putResponse = restTemplate.exchange(getBaseUrl().concat("update/{uid}"), HttpMethod.PUT, entity, UserDTO.class, 2).getBody();
		
		assertEquals("Bhuvana", putResponse.getUserName());
	}

//	@Test
//	void testDeleteUser() {
//	    // Perform the delete operation
//	    ResponseEntity<Void> deleteResponse = restTemplate.exchange(
//	        getBaseUrl().concat("delete/{uid}"),
//	        HttpMethod.DELETE,
//	        null,
//	        Void.class,
//	        19
//	    );
	    //assertNull(deleteResponse);
	    //assertEquals(HttpStatus.NO_CONTENT, deleteResponse.getStatusCode());
	    //System.out.println(deleteResponse.getStatusCode());
//
//	    ResponseEntity<UserDTO> getResponse = restTemplate.getForEntity(
//	        getBaseUrl().concat("getuser/{uid}"),
//	        UserDTO.class,
//	        15
//	    );
//	    assertEquals(HttpStatus.NOT_FOUND, getResponse.getStatusCode());
//	}
}



