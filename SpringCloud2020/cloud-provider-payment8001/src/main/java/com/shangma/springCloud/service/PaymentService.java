package com.shangma.springCloud.service;

import com.shangma.springCloud.entities.Payment;

public interface PaymentService {
    int create(Payment payment);
    Payment findById(Long id);
}
