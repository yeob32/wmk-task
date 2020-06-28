package com.example.demo.application;

import com.example.demo.domain.task.ReqTask;
import com.example.demo.domain.task.ResTask;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TaskService {

    private final ExtractService extractService;

    public ResTask print(ReqTask inputTask) {
        return output(inputTask, extractService.extract(inputTask));
    }

    public ResTask output(ReqTask inputTask, String extract) {
        int outputUnit = inputTask.getOutputUnit();
        int extractLength = extract.length();

        if (outputUnit > extractLength) {
            return ResTask.builder()
                    .rest(extract)
                    .build();
        }

        // (9/2) * 2
        // 1,2,3,4,5,6,7,8,9
        int sub = (extractLength / outputUnit) * outputUnit;
        String value = extract.substring(0, sub);
        String rest = extract.substring(sub);

        return ResTask.builder()
                .value(value)
                .rest(rest)
                .build();
    }
}
