package com.medicare.service;

import com.medicare.configuration.JwtRequestFilter;
import com.medicare.dao.OrderDetailDao;
import com.medicare.dao.ProductDao;
import com.medicare.dao.UserDao;
import com.medicare.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {


    private static final String ORDER_PLACED = "Placed";

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ProductDao productDao;
    public void placeOrder(OrderInput orderInput) {
        List<OrderProductQty> orderProductQtyList= orderInput.getOrderProductQties();

        for(OrderProductQty o: orderProductQtyList) {
            Product product= productDao.findById(o.getProductId()).get();

            String currentUser= JwtRequestFilter.CURRENT_USER;
            User user=userDao.findById(currentUser).get();

            OrderDetail orderDetail=new OrderDetail(
                    orderInput.getUserFullName(),
                    orderInput.getUserFullAddress(),
                    orderInput.getUserContactNumber(),
                    orderInput.getUserAlternateContactNumber(),
                    ORDER_PLACED,
                    product.getProductDiscountedPrice()*o.getProductQty(),
                    product,
                    user
            );
            orderDetailDao.save(orderDetail);
        }
    }


}
