package com.github.n1ay.icey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
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
