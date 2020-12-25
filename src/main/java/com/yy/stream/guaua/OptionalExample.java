package com.yy.stream.guaua;

import com.yy.entity.Person;
import com.yy.entity.Student;
import com.yy.entity.Ticket;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @description: null is bad
 * @author: yy
 * @date: 2020/12/25
 */
public class OptionalExample {


    public static void optional(List<String> list){

        // 使用

        // 1. 创建空引用
        Optional.empty();
        // 不能创建空值引用
        Optional.of("hahahha");

        Optional<Object> optional = Optional.ofNullable(null);
        // 不建议使用
        boolean present = optional.isPresent();
        // 类似于 map、filter、flatMap
        optional.ifPresent(System.out::println);

        System.out.println(optional.orElse("空值引用"));
        System.out.println(optional.orElseGet(() -> {
            return "空值引用出错";
        }));

        // 应用
        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);

    }


    public static void optionalTwo(){
        Student student = new Student();
        // 获取一个复杂对象的某个属性值
        int total = student.getPerson().getTicket().getTotal();
        // 多么糟糕的代码
        if (student != null) {
            Person person = student.getPerson();
            if (person != null) {
                Ticket ticket = person.getTicket();
                if (ticket != null) {
                    int total1 = ticket.getTotal();
                }
            }
        }

        Integer total2 = Optional.ofNullable(student)
                .map(Student::getPerson)
                .map(Person::getTicket)
                .map(Ticket::getTotal)
                .orElse(null);

    }

    public static void main(String[] args) {
        optional(null);
    }

}
