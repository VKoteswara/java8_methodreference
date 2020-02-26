package com.nisum.demos;

import com.nisum.beans.Order;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderComparator {
    static int compareByOrderName(Order first, Order second){
        return first.getOrderName().compareTo(second.getOrderName());
    }

    int compareByOrderId(Order first, Order second){
        return Integer.compare(first.getOrderId(),second.getOrderId());
    }
    public static void main(String[] args) {
        List<Order> orderList = Arrays.asList(
                new Order(1,"Tv"),
                new Order(2,"Mobile"),
                new Order(3,"Byke")
        );
        //Here, a static methode reference
        System.out.println("Here, a static methode reference");
        Collections.sort(orderList,OrderComparator::compareByOrderName);
        orderList.forEach(
                System.out::println
        );
        //Here, Instance method reference
        System.out.println("Here, a instance methode reference");
        OrderComparator orderComparator =new OrderComparator();
        Collections.sort(orderList,orderComparator::compareByOrderId);

        orderList.forEach(
                System.out::println
        );
    }
}
