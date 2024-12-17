package tests;

import org.example.*;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class PixPaymentTest {

    @Test
    public void testPixPaymentWithStoneProcessor() {
        Processor processor = StoneProcessor.getInstance();
        Pix pixPayment = new Pix(processor, 0.0);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        pixPayment.pay(150.0);

        assertTrue(output.toString().contains("Processando pagamento de 150.0 via Stone"));
    }

    @Test
    public void testPixPaymentWithMercadoPagoProcessor() {
        Processor processor = MercadoPagoProcessor.getInstance();
        Pix pixPayment = new Pix(processor, 0.0);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        pixPayment.pay(200.0);

        assertTrue(output.toString().contains("Processando pagamento de 200.0 via Mercado Pago"));
    }

    @Test
    public void testPixPaymentWithPagSeguroProcessor() {
        Processor processor = PagSeguroProcessor.getInstance();
        Pix pixPayment = new Pix(processor, 0.0);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        pixPayment.pay(300.0);

        assertTrue(output.toString().contains("Processando pagamento de 300.0 via PagSeguro"));
    }

}
