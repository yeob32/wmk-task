package com.example.demo.application;

import com.example.demo.domain.task.ReqTask;
import com.example.demo.utils.Extractor;
import com.example.demo.utils.HtmlUtil;
import org.springframework.stereotype.Service;

@Service
public class ExtractService {

    public String extract(ReqTask inputTask) {
        String html = HtmlUtil.getHtml(inputTask.getUrl(), inputTask.getScope());
        return Extractor.extractIntegerOrAlpha(html);
    }
}
