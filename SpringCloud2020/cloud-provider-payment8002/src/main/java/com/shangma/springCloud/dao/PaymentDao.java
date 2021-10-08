package com.shangma.springCloud.dao;

import com.shangma.springCloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment findById(@Param("id") Long id);
    List<Payment> findAll();
}
