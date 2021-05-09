package com.tate.springcloud.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author tangmf
 * @Date 2021/5/7 8:10 下午
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private Long id;
    private Long userId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
