package com.github.n1ay.icey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class Controller {
    public String indexMsg;

    @Autowired
    public void setIndexMsg(String indexMsg) {
        this.indexMsg = indexMsg;
    }

    @RequestMapping("/")
    public String index() {
        return indexMsg;
    }
}
