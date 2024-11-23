package com.mikael.web.test.thread.day009;
/**
 * AtomicReference 使用 （类似于乐观锁）
 */

import java.util.concurrent.atomic.AtomicReference;

public class CASTest {

    public static void main(String[] args) {
        User user3 = new User(1, "z3");
        User user4 = new User(2, "l4");

        AtomicReference<User> userAtomicReference = new AtomicReference<>();
        userAtomicReference.set(user3);

        System.out.println(
                userAtomicReference.compareAndSet(user3, user4)
                        + "\t"
                        + userAtomicReference.get().getName());
    }
}
