package com.tate.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Author tangmf
 * @Date 2021/4/25 8:56 下午
 * @Description
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        ////暂停毫秒，测试线程数直接失败
        //try {
        //    TimeUnit.MILLISECONDS.sleep(800);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        log.info(Thread.currentThread().getName() + "\t" + "....A");
        return "---testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "---testB";
    }

    @GetMapping("/testD")
    public String testD() {
        //暂停毫秒，测试线程数直接失败
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testD 测试 RT");
        return "---testD";
    }

    @GetMapping("/testE")
    public String testE() {
        int age = 10 / 0;
        log.info("testD 测试 异常比例");
        return "---testE";
    }

    @GetMapping("/testF")
    public String testF() {
        int age = 10 / 0;
        log.info("testF 测试 异常数");
        return "---testF";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_hotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        int age = 10/0;
        return "---testHotKey";
    }

    public String deal_hotKey(String p1, String p2, BlockException exception) {
        return "----deal_hotKey";//sentinel自带的提示Blocked by Sentinel (flow limiting)
    }
}
