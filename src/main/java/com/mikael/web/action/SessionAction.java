package com.mikael.web.action;

import com.mikael.web.test.Jdk8Features.User;
import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author
 * @version 1.0.0
 */

@RestController("/session")
public class SessionAction {

    private HashMap<String, String> hashMap = new HashMap<String, String>(16);

    @GetMapping("/login")
    public Result login(HttpServletRequest request) {
        User hua = new User(12, "hua");

        HttpSession session = request.getSession();
        session.setAttribute(12+"", hua);
        String id = request.getSession().getId();
        hashMap.put(id, "/login");


        return ResultUtil.success(id);
    }

    @GetMapping("/getSession")
    public Result getSession(HttpServletRequest request) {
        String id = request.getSession().getId();
        String s = hashMap.get(id);
        return ResultUtil.success(s);
    }

}
