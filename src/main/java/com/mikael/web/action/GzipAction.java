package com.mikael.web.action;


import com.mikael.web.utils.result.Result;
import com.mikael.web.utils.result.ResultUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpResponse;
import java.util.zip.GZIPOutputStream;

/**
 * gzip 的使用例子
 */
@RestController
@RequestMapping("/gzip")
public class GzipAction {

    @GetMapping("/test01")
    public void test01(HttpServletResponse response) {

        String data = "your large data here";
        response.setHeader("Content-Encoding", "gzip");
        response.setContentType("application/json");
        try (OutputStream os = response.getOutputStream();
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(os)
        ) {
            gzipOutputStream.write(data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
