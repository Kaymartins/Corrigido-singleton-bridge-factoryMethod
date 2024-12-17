package org.example;

public class Boleto extends Payment{

    private final double fixedFee = 2.5;

    public Boleto(Processor processor, double percentualFee) {
        super(processor, percentualFee);
    }

    @Override
    public void pay(double amount) {
        double totalAmount = (amount * (1 + this.percentualFee) + fixedFee);
        processor.processPayment(totalAmount);
    }
}
