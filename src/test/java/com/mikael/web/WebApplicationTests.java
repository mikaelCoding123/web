package com.mikael.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@SpringBootTest
class WebApplicationTests {

    @Test
    void contextLoads() {
    }

}

class test {

    public static void main(String[] args) {


        Path sourcePath = Paths.get("Z:\\yu\\y.txt");
//        Path destinationPath = Paths.get("Z:\\yu\\");

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        String[] a = new String[]{"1", "2", "3","4","5"};

        for (int i = 0; i < 5; i++) {
            threadLocal.set(a[i]);
            new Thread(() -> {
                for (int t = 0; t < 10000; t++) {
                    try {
                        Files.copy(sourcePath, Paths.get("Z:\\yu\\p" + threadLocal.get() + "" + t + ".txt"), StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).run();
        }

    }


}
