package com.example.demo.api;

import com.example.demo.application.TaskService;
import com.example.demo.domain.TaskDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.MalformedURLException;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/submit")
    public ResponseEntity<TaskDto.Response> submit(TaskDto.Request reqDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(new TaskDto.Response(taskService.print(reqDto)), HttpStatus.OK);
    }

    @ExceptionHandler(MalformedURLException.class)
    protected ResponseEntity<String> handleMalformedURLException(MalformedURLException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
