package com.example.demo.application;

import com.example.demo.domain.Task;
import com.example.demo.domain.TaskDto;
import com.example.demo.utils.Extractor;
import org.springframework.stereotype.Service;

@Service
public class ExtractService {

    public Task extractHtml(TaskDto.Request task, String html) {

        String extract = Extractor.extractIntegerOrAlpha(html);

        if(task.getOutputUnit() > extract.length()) {
            return Task.builder()
                    .rest(extract)
                    .build();
        }

        // (9/2) * 2
        // 1,2,3,4,5,6,7,8,9
        int sub = (extract.length() / task.getOutputUnit()) * task.getOutputUnit();
        String value = extract.substring(0, sub);
        String rest = extract.substring(sub);

        return Task.builder()
                .value(value)
                .rest(rest)
                .build();
    }
}
