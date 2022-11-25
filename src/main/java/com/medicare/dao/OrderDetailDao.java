package com.medicare.dao;

import com.medicare.entity.OrderDetail;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailDao extends JpaRepository<OrderDetail,Long> {

}
