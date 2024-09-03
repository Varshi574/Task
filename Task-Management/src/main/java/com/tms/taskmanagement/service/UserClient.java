package com.tms.taskmanagement.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(url="http://localhost:9093" ,name="User-Service")
public interface UserClient 
{
	@PutMapping("user/updatetid/{userId}/{taskId}/{projectId}/{taskStatus}")
	public void updateTid(@PathVariable("userId") Long uid, @PathVariable("taskId") Long taskid,@PathVariable("projectId") Long pid, @PathVariable String taskStatus);

}
