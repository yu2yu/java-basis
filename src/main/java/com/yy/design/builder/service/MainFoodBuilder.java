package com.yy.design.builder.service;

import com.yy.design.builder.entity.Product;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @description: 食物套餐构建者
 * @author: yy
 * @date: 2021/1/13
 */
public class MainFoodBuilder {

    @Setter
    @Getter
    private String title;
    @Setter
    @Getter
    private int count;
    private List<Product> foods = new ArrayList<>();

    public MainFoodBuilder(String title, int count) {
        this.title = title;
        this.count = count;
    }

    public MainFoodBuilder appendFood(Product product){
        foods.add(product);
        return this;
    }

    public MainFoodBuilder appendDrink(Product product){
        foods.add(product);
        return this;
    }

    public MainFoodBuilder appendExtra(Product product){
        foods.add(product);
        return this;
    }

    public String getFoodDetails(){
        // 需要计算出总价
        StringBuilder sb = new StringBuilder();
        sb.append("套餐: "+this.getTitle()).append(String.format(",%s份\r\n",this.getCount()));
        foods.forEach(k -> {
            sb.append(String.format("%s,单价为：%s,重量：%s \r\n",k.getTitle(),k.getPrice(),k.getHeavity()*count));
        });
        String totalPrice = foods.stream().map(Product::getTotalPrice).reduce(BigDecimal::add).get().multiply(new BigDecimal(count)).toString();
        sb.append(totalPrice);
        return sb.toString();
    }

}
