package com.SpringBoot.CrudDemo.entity;

import com.SpringBoot.CrudDemo.Enum.BillStatus;
import com.SpringBoot.CrudDemo.Enum.PaymentType;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private int paymentId;


    @Column(name = "amountToPay")
    private int amountToPay;

    @Column(name="amountPaid")
    private int amountPaid;

    @Column(name = "payment_type")
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @Column(name="billStatus")
    @Enumerated(EnumType.STRING)
    private BillStatus billStatus;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ticket")
    private Ticket ticket;

    public Payment(){

    }

    public Payment( int amountToPay,int amountPaid, PaymentType paymentType, BillStatus billStatus) {

        this.amountToPay = amountToPay;
        this.amountPaid=amountPaid;
        this.paymentType = paymentType;
        this.billStatus = billStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getAmountToPay() {
        return amountToPay;
    }

    public void setAmountToPay(int amountToPay) {
        this.amountToPay = amountToPay;
    }

    public int getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(int amountPaid) {
        this.amountPaid = amountPaid;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", amountToPay=" + amountToPay +
                ", amountToPaid=" + amountPaid +
                ", paymentType=" + paymentType +
                ", billStatus=" + billStatus +
                '}';
    }
}
