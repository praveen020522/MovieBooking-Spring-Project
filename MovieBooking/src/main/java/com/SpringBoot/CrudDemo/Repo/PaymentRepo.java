package com.SpringBoot.CrudDemo.Repo;

import com.SpringBoot.CrudDemo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment,Integer> {

}
