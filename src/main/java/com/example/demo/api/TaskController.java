package com.example.demo.api;

import com.example.demo.application.TaskService;
import com.example.demo.domain.task.ReqTask;
import com.example.demo.domain.task.ResTask;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/submit")
    public ResponseEntity<ResTask> submit(ReqTask reqDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(taskService.print(reqDto), HttpStatus.OK);
    }
}
