package com.mikael.web.test.thread.day009;


import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {

    public static void main(String[] args) {

        User z3 = new User(1, "z3");

        User l4 = new User(2, "l4");

        AtomicStampedReference<User> userAtomicStampedReference =
                new AtomicStampedReference<User>(z3, 1);

        userAtomicStampedReference.compareAndSet(z3, l4, 1, 2);
        System.out.println(userAtomicStampedReference.getReference().toString());
    }
}
