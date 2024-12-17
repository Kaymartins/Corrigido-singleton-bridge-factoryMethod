package tests;

import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PaymentFactoryTest {

    @Test
    public void testFactoryCreatesPixPayment(){
        Processor processor = StoneProcessor.getInstance();
        Payment payment = PaymentFactory.createPayment("Pix", processor, 0.0);

        assertTrue(payment instanceof Pix);
    }

    @Test
    public void testFactoryCreatesBoletoPayment(){
        Processor processor = StoneProcessor.getInstance();
        Payment payment = PaymentFactory.createPayment("Boleto", processor, 0.5);
        assertTrue(payment instanceof Boleto);
    }

    @Test
    public void testFactoryCreatesCreditCardPayment(){
        Processor processor = PagSeguroProcessor.getInstance();
        Payment payment = PaymentFactory.createPayment("CreditCard", processor, 0.1);

        assertTrue(payment instanceof CreditCard);
    }

    @Test
    public void testFactoryInvalidPaymentThrowsException(){
        Processor processor = StoneProcessor.getInstance();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PaymentFactory.createPayment("Invalid", processor, 0.0);
        });

        assertEquals("Pagamento inexistente", exception.getMessage());
    }
}
