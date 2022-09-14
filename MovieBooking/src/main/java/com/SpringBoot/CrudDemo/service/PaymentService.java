package com.SpringBoot.CrudDemo.service;

import com.SpringBoot.CrudDemo.Enum.BillStatus;
import com.SpringBoot.CrudDemo.Enum.PaymentStatus;
import com.SpringBoot.CrudDemo.Enum.PaymentType;
import com.SpringBoot.CrudDemo.Repo.PaymentRepo;
import com.SpringBoot.CrudDemo.entity.Payment;
import com.SpringBoot.CrudDemo.entity.Ticket;
import com.SpringBoot.CrudDemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;


    public String makePayment(Map<String,String> pay){

        Ticket ticket=ticketService.getById(Integer.parseInt(pay.get("ticket")));

        User user=userService.getById(Integer.parseInt(pay.get("user")));
        int amt= Integer.parseInt(pay.get("amount"));

        if(ticket!=null&& user!=null){


            Payment payment = new Payment();
            payment.setAmountToPay(ticket.getAmount());
            payment.setPaymentType(PaymentType.valueOf(pay.get("paymentType")));
            payment.setAmountPaid(amt);

            if(amt==ticket.getAmount()) {

                payment.setBillStatus(BillStatus.SUCCESS);
                ticket.setPaymentStatus(PaymentStatus.PAID);
                ticketService.saveTicket(ticket);
                payment.setTicket(ticket);


            }
            else{
                payment.setBillStatus(BillStatus.FAILURE);
            }
            paymentRepo.save(payment);
            return "Amount Paid";
        }
        else return "Invalid ENTRY";


    }

    public List<Payment> displayPayment(){
        return paymentRepo.findAll();
    }
}
