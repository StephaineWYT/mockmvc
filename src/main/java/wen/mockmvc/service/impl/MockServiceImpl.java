package wen.mockmvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wen.mockmvc.pojo.User;
import wen.mockmvc.repository.MockRepository;
import wen.mockmvc.service.MockService;

@Service
public class MockServiceImpl implements MockService {

    @Autowired
    private MockRepository mockRepository;

    @Override
    public User getUser(Long id) {
        return mockRepository.findById(id).get();
    }

    @Override
    public void out(Long id) {
        System.out.println(id);
    }

}