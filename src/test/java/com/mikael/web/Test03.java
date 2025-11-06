package com.mikael.web;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 *
 * @author 
 * @version 1.0
 * @date 2025/7/14
 */

@SpringBootTest
public class Test03 {


  @Test
  void test(){
  System.out.println("天天");
  
  }
public static void main(String[] args){
  ConcurrentSkipListMap<String, Integer> skipListMap = new ConcurrentSkipListMap<>();
  skipListMap.put("a", 1);
  skipListMap.put("ab", 1);
  skipListMap.put("ab", 1);
  skipListMap.put("ab", 1);

  String a= "3.41.198273";
  String verion = "3.54."+100099;
    System.out.println(verion);

    String s = """
            
            """;

    int c = "13065975433".hashCode()%1024;
    System.out.println(c);

}
}
