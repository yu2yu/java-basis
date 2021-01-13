package com.yy.design.builder.service;

import com.yy.design.builder.entity.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 构建者指导者
 * @author: yy
 * @date: 2021/1/13
 */
public class FoodDirector {

    List<MainFoodBuilder> mainFood = null;

    public List<MainFoodBuilder> getDanChao(int count){

        mainFood = new ArrayList<>();

        Product food = new Product("蛋炒饭", 1, new BigDecimal("15.99"));
        Product drink = new Product("可乐", 1, new BigDecimal("5.00"));
        Product extra = new Product("火腿", 1, new BigDecimal("2.00"));

        MainFoodBuilder chaoFan = new MainFoodBuilder("蛋炒饭套餐",count);
        chaoFan.appendFood(food).appendDrink(drink).appendExtra(extra);

        for (int i = 0; i < count; i++) {
            mainFood.add(chaoFan);
        }
        return mainFood;
    }

    public List<MainFoodBuilder> getnoodle(int count){

        mainFood = new ArrayList<>();

        Product food2 = new Product("炸酱面", 1, new BigDecimal("13.99"));
        Product drink = new Product("可乐", 1, new BigDecimal("5.00"));
        Product extra = new Product("火腿", 1, new BigDecimal("2.00"));

        MainFoodBuilder noodle = new MainFoodBuilder("炸酱面套餐",count);
        noodle.appendFood(food2).appendDrink(drink).appendExtra(extra);

        for (int i = 0; i < count; i++) {
            mainFood.add(noodle);
        }
        return mainFood;
    }

    @Test
    public void testBuilder() {
        List<MainFoodBuilder> danChao = new FoodDirector().getDanChao(1);
        System.out.println(danChao.get(0).getFoodDetails());
        System.out.println("=========");
        List<MainFoodBuilder> noodle = new FoodDirector().getnoodle(2);
        System.out.println(noodle.get(0).getFoodDetails());
    }

}
