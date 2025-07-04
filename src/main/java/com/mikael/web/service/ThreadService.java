package com.mikael.web.service;

import com.mikael.web.test.bo.User;

public interface ThreadService {
    void run(User user) throws Exception;
}
