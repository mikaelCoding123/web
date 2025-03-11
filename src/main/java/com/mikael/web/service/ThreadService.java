package com.mikael.web.service;

import com.mikael.web.test.bo.User;

public interface ThreadService {
   public void run(User user) throws Exception;
}
