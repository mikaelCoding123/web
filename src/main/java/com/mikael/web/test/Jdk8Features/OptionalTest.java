package com.mikael.web.test.Jdk8Features;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

/**
 * 参考网址：https://blog.csdn.net/u012068483/article/details/102783572?depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1&utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromBaidu-1
 *
 * <p>
 *
 * <p>List<Employee> employees = Optional.ofNullable(company).// 若company为空,则返回空Optional
 * map(theCompany -> theCompany.getEmployees()). // 若getEmployees()返回空,则返回空Optional
 * orElse(Collections.EMPTY_LIST); // 若上述两步中有一步为空,则返回空列表
 *
 * <p>// 遍历员工列表employees employees.forEach(employee -> System.out.println(employee));
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<Object> o = Optional.ofNullable(null);
        Optional<Integer> o2 = Optional.ofNullable(1);
        String s = "123";
        User user = new User(123, "hua");
        HashMap<String, String> hashMap = new HashMap<>(10);
        ArrayList<User> users = new ArrayList<User>();
        users.add(user);
        // 判断user 是否为null，如果是null则new User（）不是返回 user
        User user1 = Optional.ofNullable(user).orElse(new User(232, "uyihk"));

        if (users.size() > 0) {
            System.out.println("111111");
            System.out.println(hashMap.size());
            users.forEach(a -> test01(a));
        }
        Optional<User> user2 = Optional.ofNullable(user);
        System.out.println(user2.get().getName());
        System.out.println(user1.getName());
        System.out.println("==========");
        String a = "";
        System.out.println(a);


    }

    public static void test01(Object obj) {
        System.out.println(obj.toString());
    }
}
