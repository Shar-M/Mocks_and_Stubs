package cashregister;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CashRegisterTest {
    @Test
    public void shouldPrintAPurchasedItem() {
        Item[] items = {new Item("Jacket", 12.99)};
        Purchase purchase = new Purchase(items);
        MockPrinter mockPrinter = new MockPrinter();
        new CashRegister(mockPrinter).process(purchase);
        assertEquals(true, mockPrinter.hasPrinted());
    }
}
