package wen.mockmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wen.mockmvc.pojo.User;
import wen.mockmvc.service.MockService;

@RestController
@RequestMapping(value = "mock")
public class MockController {

    @Autowired
    private MockService mockService;

    @GetMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id) {
        User user = mockService.getUser(id);
        return user;
    }

}
