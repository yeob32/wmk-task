package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskDto;
import com.example.demo.utils.HtmlUtil;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final ExtractService extractService;

    public TaskService(ExtractService extractService) {
        this.extractService = extractService;
    }

    public Task print(TaskDto.Request task) {
        String html = HtmlUtil.getHtml(task.getUrl(), task.getScope());

        return extractService.extractHtml(task, html);
    }
}
