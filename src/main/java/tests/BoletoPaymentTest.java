package tests;

import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BoletoPaymentTest {

    @Test
    public void testBoletoPaymentWithStoneProcessor() {
        Processor processor = StoneProcessor.getInstance();
        Boleto boletoPayment = new Boleto(processor, 0.1); // 10% de taxa

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        boletoPayment.pay(100.0);

        double expectedAmount = (100.0 * 1.1) + 2.5;
        assertTrue(output.toString().contains("Processando pagamento de " + expectedAmount + " via Stone"));
    }

    @Test
    public void testBoletoPaymentWithPagSeguroProcessor() {
        Processor processor = PagSeguroProcessor.getInstance();
        Boleto boletoPayment = new Boleto(processor, 0.0); // Sem taxa percentual

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        boletoPayment.pay(100.0);

        double expectedAmount = 100.0 + 2.5;
        assertTrue(output.toString().contains("Processando pagamento de " + expectedAmount + " via PagSeguro"));
    }

    @Test
    public void testBoletoPaymentWithMercadoPagoProcessor() {
        Processor processor = MercadoPagoProcessor.getInstance();
        Boleto boletoPayment = new Boleto(processor, 0.05); // 5% de taxa

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        boletoPayment.pay(200.0);

        double expectedAmount = (200.0 * 1.05) + 2.5;
        assertTrue(output.toString().contains("Processando pagamento de " + expectedAmount + " via Mercado Pago"));
    }
}
