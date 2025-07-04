package com.mikael.web.test.Jdk8Features;

import java.util.*;
import java.util.stream.Stream;

/**
 * 关于jdk8新特性filter
 */
public class StreamAPI {

    public static void main(String[] args) {

        int[] Aryyays = {1, 23, 4, 324, 5, 23};
        List<int[]> ints = List.of(Aryyays);
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        hashMap.put("hua", 12);
        hashMap.put("li", 23);
        hashMap.put("mu", 4);
        hashMap.put("zhang", 332);
        hashMap.put("liu", 98);
        hashMap.put("liu", 111);
        List<String> list = Arrays.asList("126", "2318", "1313", "sfsfsf", "化", "126");
        Iterator<String> iterator = list.iterator();


        List<User> objects =
                Arrays.asList(
                        new User(12, "hua", 89),
                        new User(12, "li2", 234),
                        new User(12, "zhao1", 17),
                        new User(12, "zhao1", 64));

        List<User> objectsSameAge =
                Arrays.asList(
                        new User(12, "hua", 89),
                        new User(12, "li2", 89),
                        new User(12, "zhao1", 89),
                        new User(12, "zhao1", 89));
        System.out.println("===========allmatch==============");
        System.out.println(objects.stream().allMatch((s) -> s.getAge() == 89));
        // filter 过滤 object中的值
        objects.stream()
                .filter((s) -> s.getAge() > 100)
                .forEach((a) -> System.out.println(a.getName()));
        list.stream().filter((a) -> a.endsWith("3") && a.startsWith("1")).forEach(System.out::print);
        System.out.println();
        // distinct   去重打印
        System.out.println("------------distinct   去重------------");
        Stream<String> distinct = list.stream().distinct();
        distinct.forEach(System.out::println);
        System.out.println("===========objects==============");
        Stream<User> distinct1 = objects.stream().distinct();
        distinct1.forEach((a) -> System.out.println(a.getName()));
        // 排序sorted
        System.out.println("===========objects sorted==============");
        objects.stream().map(user -> user.getAge()).sorted().forEach(System.out::print);

        // map(Function f) 接收 Lambda ， 将元素转换成其他形式或提取信息;接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
        // mapToDouble(ToDoubleFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
        // mapToInt(ToIntFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
        // mapToLong(ToLongFunction f) 接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
        // flatMap(Function f) 接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。

        // todo  map

        // 一下操作为Strean的终止操作 放在最后
        // allmatch allMatch——检查是否匹配所有元素
        // anyMatch——检查是否至少匹配一个元素
        // noneMatch——检查是否没有匹配的元素
        // findFirst——返回第一个元素
        // findAny——返回当前流中的任意元素
        // count——返回流中元素的总个数
        // max——返回流中最大值
        // min——返回流中最小值
        System.out.println("===========allmatch 表示流中的内容要全部都符合=============");
        objects.stream().forEach((param) -> System.out.println(param.getAge()));
        // 执行结果为 false
        System.out.println(objects.stream().allMatch((param) -> param.getAge() == 89));
        // objectsSameAge 中的age都一样 执行结果为 true
        System.out.println(objectsSameAge.stream().allMatch(param -> param.getAge() == 89));
        // limit limit(long maxSize) 截取前面maxSize条数据,在上面的代码的基础上我加了个方法
        objectsSameAge.stream()
                .filter(param -> param.getName() != "zhao1")
                .limit(2)
                .allMatch(param -> param.getAge() == 89);

        ArrayList<User> objects1 = new ArrayList<>();
        System.out.println("***************************");
        hashMap.entrySet().stream()
                .filter(
                        a -> {
                            return a.getValue() > 12;
                        })
                .forEach(a -> System.out.println(a));
        System.out.println("***************************");
        hashMap.entrySet().stream().forEach(a -> System.out.println(a));
        Set<String> keySet = hashMap.keySet();
        keySet.stream().forEach(a -> System.out.println(a));

    }

    // 全排列
    // TODO
    void Arrangement(int[] array) {
    }
}
