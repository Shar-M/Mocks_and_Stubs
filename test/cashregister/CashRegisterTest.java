package cashregister;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashRegisterTest {
    @Test
    public void checkWhetherPrinterGetsCalled() {
        Item[] items = {new Item("Jacket", 12.99)};
        Purchase purchase = new Purchase(items);
        MockPrinter mockPrinter = new MockPrinter();

        new CashRegister(mockPrinter).process(purchase);

        assertEquals(true, mockPrinter.isPrinterCalled());
    }

    @Test
    public void shouldCheckIfThePrinterGetsCalledWithAStub() {
        Item[] items = {new Item("Jacket", 12.99)};
        StubPurchase purchase = new StubPurchase(items);
        MockPrinter mockPrinter = new MockPrinter();

        new CashRegister(mockPrinter).process(purchase);

        assertEquals("happy testing!", mockPrinter.getPrintedString());
    }
}
