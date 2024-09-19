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

class test{

    public static void main(String[] args) {
        Path sourcePath = Paths.get("Z:\\yu\\y.txt");
//        Path destinationPath = Paths.get("Z:\\yu\\");

        try {
            for (int i = 0; i < 3000; i++) {
                Files.copy(sourcePath, Paths.get("Z:\\yu\\p"+i+".txt"), StandardCopyOption.REPLACE_EXISTING);
            }








            System.out.println("文件复制成功！");
        } catch (IOException e) {
            System.out.println("文件复制失败: " + e.getMessage());
        }
    }


}
