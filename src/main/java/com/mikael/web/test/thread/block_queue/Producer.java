/*
 * projectName: JUC
 * fileName: Procutor.java
 * packageName: Thread.block_queue
 * date: 2020-11-05
 * copyright(c) 2017-2020 xxx公司
 */
package com.mikael.web.test.thread.block_queue;

import java.util.concurrent.BlockingQueue;

/**
 * @version: V1.0
 * @author: mikael
 * @className: Procutor
 * @packageName: Thread.block_queue
 * @description:
 * @date: 2020-11-05
 */
public class Producer implements Runnable {
    private int element = 0;
    private final BlockingQueue<Integer> blockingQueue;

    public Producer(BlockingQueue<Integer> blockingQueue) {

        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (element < 100) {
            System.out.println("element\t" + element);
            blockingQueue.offer(element++);
        }
        System.out.println("Producer done!!!!");
    }
}
