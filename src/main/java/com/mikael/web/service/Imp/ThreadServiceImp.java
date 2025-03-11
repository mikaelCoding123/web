package com.mikael.web.service.Imp;

import com.mikael.web.service.ThreadService;
import com.mikael.web.test.bo.User;
import org.springframework.stereotype.Service;

@Service("ThreadServiceImp")
public class ThreadServiceImp implements ThreadService {

    @Override
    public void run(User user) throws Exception {
        new Thread01Imp(user, 122).call();
    }
}
