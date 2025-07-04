package com.mikael.web.test.Jdk8Features.merge;



import com.mikael.web.test.bo.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Java 8 中 Map 骚操作之 merge() 的用法
 *
 * @author mikael
 */
public class MergeTest {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        User user1 = new User(1, "hua12", 12);
        User user2 = new User(1, "hua12", 11);
        User user3 = new User(1, "hua1", 37);
        User user4 = new User(1, "hua1", 33);
        users.add(user4);
        users.add(user3);
        users.add(user2);
        users.add(user1);
        HashMap<String, Integer> userhashMap = new HashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("1", 100);
        map.put("2", 30000000);
        map.put("3", 400);
        map.put("4", 500);
        // max 可以换成其他的形式
        // 将计算的值存入hashmap中
        users.forEach(user -> userhashMap.merge(user.getName(), user.getAge(), Integer::sum));
        System.out.println(userhashMap);
        users.forEach(user -> userhashMap.merge(user.getName(), user.getAge(), Integer::compareTo));
        System.out.println(userhashMap);
        // 如果 key 对应的 value 不存在，则返回该 value 值，如果存在，则返回通过 remappingFunction 重新计算后的值。
        // key不存在map中则返回value的值
        // key存在map且value的值也是相同的则根据remappingFunction 重新计算后返回的值
        // key存在map且value的值不相同的则根据remappingFunction 重新计算后返回的值
        Integer merge =
                map.merge(
                        "2",
                        30000,
                        (oldvalue, newvalue) -> {
                            if (oldvalue > newvalue) {
                                return oldvalue;
                            } else {
                                return newvalue;
                            }
                        });

        System.out.println(merge);
    }
}
