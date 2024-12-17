package org.example;

public class PaymentFactory {
    public static Payment createPayment(String payment, Processor processor, double percentualFee) {
        Class<?> clazz = null;
        Object object = null;

        try{
            clazz = Class.forName("org.example." + payment);
            object = clazz.getConstructor(Processor.class, double.class).newInstance(processor, percentualFee);
        } catch (Exception e) {
            throw new IllegalArgumentException("Pagamento inexistente");
        }

        if(!(object instanceof Payment)){
            throw new IllegalArgumentException("Pagamento invalido");
        }

        return (Payment) object;
    }
}
