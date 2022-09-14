package com.SpringBoot.CrudDemo.rest;

import com.SpringBoot.CrudDemo.entity.Payment;
import com.SpringBoot.CrudDemo.service.PaymentService;
import com.SpringBoot.CrudDemo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    private PaymentService paymentService;

    @PostMapping("/makePayment")
    public ResponseEntity<String> makePayment(@RequestBody Map<String,String> pay){
        return new ResponseEntity<>(paymentService.makePayment(pay), HttpStatus.CREATED);
    }

    @GetMapping("/displayPayment")
    public List<Payment> display(){
        return paymentService.displayPayment();
    }

}
