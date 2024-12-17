package org.example;

public class MercadoPagoProcessor implements Processor{

    private static MercadoPagoProcessor instance;

    private MercadoPagoProcessor() {}

    public static MercadoPagoProcessor getInstance() {
        if(instance == null) {
            instance = new MercadoPagoProcessor();
        }
        return instance;
    }

    public void processPayment(double amount){
        System.out.println("Processando pagamento de " + amount + " via Mercado Pago");
    }
}
