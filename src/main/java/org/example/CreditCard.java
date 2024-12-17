package org.example;

public class CreditCard extends Payment {

    public CreditCard(Processor processor, double percentualFee) {
        super(processor, percentualFee);
    }

    @Override
    public void pay(double amount) {
        double totalAmount = amount * (1 + this.percentualFee);
        processor.processPayment(totalAmount);
    }
}
