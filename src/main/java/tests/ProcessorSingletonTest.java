package tests;

import org.example.MercadoPagoProcessor;
import org.example.PagSeguroProcessor;
import org.example.StoneProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProcessorSingletonTest {

    @Test
    public void testStoneProcessorSingleton() {
        StoneProcessor stoneProcessor = StoneProcessor.getInstance();
        StoneProcessor stoneProcessor2 = StoneProcessor.getInstance();
        assertSame(stoneProcessor, stoneProcessor2);
    }

    @Test
    public void testMercadoPagoProcessorSingleton() {
        MercadoPagoProcessor mercado1 = MercadoPagoProcessor.getInstance();
        MercadoPagoProcessor mercado2 = MercadoPagoProcessor.getInstance();
        assertSame(mercado1, mercado2, "MercadoPagoProcessor não está seguindo o padrão Singleton");
    }

    @Test
    public void testPagSeguroProcessorSingleton() {
        PagSeguroProcessor pagSeguro1 = PagSeguroProcessor.getInstance();
        PagSeguroProcessor pagSeguro2 = PagSeguroProcessor.getInstance();
        assertSame(pagSeguro1, pagSeguro2, "PagSeguroProcessor não está seguindo o padrão Singleton");
    }
}
