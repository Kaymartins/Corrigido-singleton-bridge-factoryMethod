package org.example;

public abstract class Payment {
    protected Processor processor;

    protected double percentualFee;

    public Payment(Processor processor, double percentualFee) {
        this.processor = processor;
        this.percentualFee = percentualFee;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setPercentualFee(double percentualFee) {
        this.percentualFee = percentualFee;
    }

    public abstract void pay(double amount);
}
