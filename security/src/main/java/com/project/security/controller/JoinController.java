package com.project.security.controller;

import com.project.security.dto.JoinDto;
import com.project.security.service.JoinService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinController {

    private JoinService joinService;

    public JoinController(JoinService joinService) {
        this.joinService = joinService;
    }

    @PostMapping("/join")
    public String join(JoinDto joinDto) {
        joinService.join(joinDto);
        return "ok";
    }

}
