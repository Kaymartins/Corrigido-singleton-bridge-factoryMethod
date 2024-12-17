package org.example;

public class PagSeguroProcessor implements Processor{

    private static PagSeguroProcessor instance;

    private PagSeguroProcessor() {}

    public static PagSeguroProcessor getInstance(){
        if(instance == null){
            instance = new PagSeguroProcessor();
        }
        return instance;

    }

    public void processPayment(double amount){
        System.out.println("Processando pagamento de " + amount + " via PagSeguro");
    }
}
