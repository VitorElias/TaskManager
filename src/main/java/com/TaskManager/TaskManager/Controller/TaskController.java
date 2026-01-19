package com.TaskManager.TaskManager.Controller;

import com.TaskManager.TaskManager.DTO.TaskRequestDTO;
import com.TaskManager.TaskManager.DTO.TaskResponseDTO;
import com.TaskManager.TaskManager.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping("/create")
    public ResponseEntity<TaskResponseDTO> create(@RequestBody TaskRequestDTO task){return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(task));}

}
