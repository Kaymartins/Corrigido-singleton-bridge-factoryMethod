package org.example;

public class StoneProcessor implements Processor {

    private static StoneProcessor instance;

    public StoneProcessor() {}

    public static StoneProcessor getInstance() {
        if (instance == null) {
            instance = new StoneProcessor();
        }
        return instance;
    }

    public void processPayment(double amount){
        System.out.println("Processando pagamento de " + amount + " via Stone");
    }
}
