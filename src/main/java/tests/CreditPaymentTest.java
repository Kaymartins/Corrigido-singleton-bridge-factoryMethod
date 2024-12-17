package tests;

import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CreditPaymentTest {

    @Test
    public void testCreditCardPaymentWithStoneProcessor() {
        Processor processor = StoneProcessor.getInstance();
        CreditCard creditCardPayment = new CreditCard(processor, 0.15); // 15% de taxa

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        creditCardPayment.pay(200.0);

        double expectedAmount = 200.0 * 1.15;
        assertTrue(output.toString().contains("Processando pagamento de " + expectedAmount + " via Stone"));
    }

    @Test
    public void testCreditCardPaymentWithMercadoPagoProcessor() {
        Processor processor = MercadoPagoProcessor.getInstance();
        CreditCard creditCardPayment = new CreditCard(processor, 0.0); // Sem taxa percentual

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        creditCardPayment.pay(250.0);

        assertTrue(output.toString().contains("Processando pagamento de 250.0 via Mercado Pago"));
    }

    @Test
    public void testCreditCardPaymentWithPagSeguroProcessor() {
        Processor processor = PagSeguroProcessor.getInstance();
        CreditCard creditCardPayment = new CreditCard(processor, 0.10); // 10% de taxa

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        creditCardPayment.pay(300.0);

        double expectedAmount = 300.0 * 1.10;
        assertTrue(output.toString().contains("Processando pagamento de " + expectedAmount + " via PagSeguro"));
    }

}
