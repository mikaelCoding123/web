package com.mikael.web.action;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;

/**
 *
 * https://blog.csdn.net/ljh_learn_from_base/article/details/137798154
 *
 * 服务端主动推送技术
 */
@RestController
@RequestMapping(value = "/sse")
@CrossOrigin
public class SseAction {
    private static Map<String, SseEmitter> sseCache = new ConcurrentHashMap<>();

    /**
     * 客户端发起订阅消息的方法
     *
     * @param id 标识ID 可理解为通道ID
     * @return
     */
    @GetMapping(value = "/subscribe", produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public SseEmitter subscribe(@RequestParam(value = "id") String id) {
        //创建一个具有自定义超时值的 SseEmitter。
        //默认情况下不设置超时值，在这种情况下，将使用 MVC Java 配置或 MVC 命名空间中配置的默认值；
        // 如果未设置超时值，则超时值取决于底层服务器的默认值:30秒。
        //SseEmitter在构造器中设置超时2秒，设置前端的重试时间为2秒，则一共需要等待4秒
        SseEmitter sseEmitter = new SseEmitter(2_000L);
        // 设置前端的重试时间:2秒
        reconnectTime(sseEmitter, 2_000L);
        //放入map缓存中
        sseCache.put(id, sseEmitter);
        //注册相关回调
        //异步请求超时时调用：当前端重连接时，会触发请求超时回调
        sseEmitter.onTimeout(() -> {
            System.out.println("触发请求超时！！！");
            sseCache.remove(id);
        });
        //注册完成时回调，以便在异步请求完成时调用。当异步请求因任何原因（包括超时和网络错误）完成时，容器线程会调用此方法。该方法可用于检测 ResponseBodyEmitter 实例是否不再可用
        sseEmitter.onCompletion(() -> {
            System.out.println("完成！！！");
            //sseCache.remove(id);
        });
        //在异步请求处理过程中出现错误时调用
        sseEmitter.onError(error -> {
            System.out.println("出现错误啦");
            //sseCache.remove(id);
            error.printStackTrace();
        });

        return sseEmitter;
    }

    /**
     * 设置前端的重试时间
     *
     * @param sseEmitter
     * @param reconnectTimeMillis 单位毫秒
     */
    private static void reconnectTime(SseEmitter sseEmitter, long reconnectTimeMillis) {
        Objects.requireNonNull(sseEmitter, "sseEmitter对象为空啦");
        //开启另一个线程
        Executors.newFixedThreadPool(1).execute(() -> {
            try {
                String dateTime = LocalDateTime.now().withNano(0).toString().replace("T", " ");
                sseEmitter.send(SseEmitter.event().reconnectTime(reconnectTimeMillis).data(String.format("连接成功:%s", dateTime)));
            } catch (IOException e) {
                //sseEmitter.completeWithError(e);
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * 推送消息
     *
     * @param id
     * @param content
     * @return
     * @throws IOException
     */
    @GetMapping(value = "/push")
    public String push(@RequestParam(value = "id") String id, @RequestParam(value = "content") String content) throws IOException {
        SseEmitter sseEmitter = sseCache.get(id);
        if (sseEmitter != null) {
            sseEmitter.send(content);
        }
        return "推送成功！";
    }

    /**
     * 服务器主动停止推送
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/stop")
    public String stop(@RequestParam(value = "id") String id) {
        SseEmitter sseEmitter = sseCache.get(id);
        if (sseEmitter != null) {
            //通过向 servlet 容器执行分派来完成请求处理，Spring MVC 会在其中再次调用，并完成请求处理生命周期。
            //注意：此方法应由应用程序调用，以完成请求处理。它不应在容器相关事件（如发送时出错）发生后使用。
            sseEmitter.complete();
            sseCache.remove(id);
        }
        return "断开连接！";
    }
}

