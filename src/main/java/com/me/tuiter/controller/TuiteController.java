package com.me.tuiter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.me.tuiter.model.Tuite;
import com.me.tuiter.model.User;
import com.me.tuiter.service.TuiteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/tuites")
public class TuiteController {
    private final TuiteService tuiteService;

    public TuiteController(TuiteService tuiteService) {
        this.tuiteService = tuiteService;
    }

    @PostMapping()
    public Tuite createTuite(@RequestBody CreateTuiteRequest request) {
        // Using dummy user while authentication is not implemented
        User dummy = new User();
        dummy.setId(1L);
        dummy.setUsername("dummyUser");
        
        return tuiteService.createTuite(request.getContent(), dummy);
    }
    
}

class CreateTuiteRequest {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
