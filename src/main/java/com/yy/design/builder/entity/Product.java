package com.yy.design.builder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @description:
 * @author: yy
 * @date: 2021/1/13
 */
@Data
@AllArgsConstructor
public class Product {

    private String title;
    private int heavity;
    private BigDecimal price;

    public BigDecimal getTotalPrice(){
        return new BigDecimal(heavity).multiply(price);
    }
}
