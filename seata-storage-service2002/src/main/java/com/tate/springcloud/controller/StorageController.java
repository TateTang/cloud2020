package com.tate.springcloud.controller;

import com.tate.springcloud.entities.CommonResult;
import com.tate.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author tangmf
 * @Date 2021/5/7 6:29 下午
 * @Description
 */
@RestController
@Slf4j
public class StorageController {

    @Autowired
    private StorageService storageService;

    @PostMapping(value = "storage/decrease")
    public CommonResult decrease(@RequestParam("productId") Long productId,
                                 @RequestParam("count") Integer count) {
        storageService.decrease(productId, count);
        return new CommonResult(200, "扣减库存成功");
    }

}
