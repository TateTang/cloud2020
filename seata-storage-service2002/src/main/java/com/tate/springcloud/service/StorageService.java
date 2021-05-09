package com.tate.springcloud.service;

/**
 * @Author tangmf
 * @Date 2021/5/7 6:28 下午
 * @Description
 */
public interface StorageService {
    void decrease(Long productId, Integer count);
}
