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
    private List<Product> foods = new ArrayList<>();


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
        sb.append("套餐: "+this.getTitle()).append("\r\n");
        foods.forEach(k -> {
            sb.append(String.format("%s,单价为：%s,重量：%s \r\n",k.getTitle(),k.getPrice(),k.getHeavity()));
        });
        String totalPrice = foods.stream().map(Product::getTotalPrice).reduce(BigDecimal::add).get().toString();
        sb.append(totalPrice);
        return sb.toString();
    }

    @Test
    public void testBuilder() {
        Product food = new Product("蛋炒饭", 1, new BigDecimal("15.99"));
        Product food2 = new Product("炸酱面", 1, new BigDecimal("13.99"));
        Product drink = new Product("可乐", 1, new BigDecimal("5.00"));
        Product extra = new Product("火腿", 1, new BigDecimal("2.00"));

        MainFoodBuilder chaoFan = new MainFoodBuilder();
        chaoFan.setTitle("蛋炒饭套餐");
        chaoFan.appendFood(food).appendDrink(drink).appendExtra(extra);
        System.out.println(chaoFan.getFoodDetails());

        System.out.println("=========");

        MainFoodBuilder noodle = new MainFoodBuilder();
        noodle.setTitle("炸酱面套餐");
        noodle.appendFood(food2).appendDrink(drink).appendExtra(extra);
        System.out.println(noodle.getFoodDetails());
    }

}
