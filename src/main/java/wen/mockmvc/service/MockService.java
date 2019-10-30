package wen.mockmvc.service;

import wen.mockmvc.pojo.User;

public interface MockService {

    User getUser(Long id);

    void out(Long id);

}
