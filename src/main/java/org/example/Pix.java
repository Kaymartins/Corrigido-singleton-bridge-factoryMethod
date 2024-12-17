package org.example;

public class Pix extends Payment{
    public Pix(Processor processor, double percentualFee) {
        super(processor, percentualFee);
    }

    @Override
    public void pay(double amount) {
        processor.processPayment(amount);
    }
}
