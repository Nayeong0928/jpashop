package jpabook.jpashop.sample.controller;

import jpabook.jpashop.sample.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class OrderSearch {

    private String memberName;
    private OrderStatus orderStatus;
}
