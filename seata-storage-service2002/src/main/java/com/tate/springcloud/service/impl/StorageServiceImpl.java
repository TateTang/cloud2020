package com.tate.springcloud.service.impl;

import com.tate.springcloud.dao.StorageDao;
import com.tate.springcloud.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author tangmf
 * @Date 2021/5/7 6:29 下午
 * @Description
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        storageDao.decrease(productId, count);
    }
}
