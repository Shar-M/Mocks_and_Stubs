package cashregister;

import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.assertEquals;

public class CashRegisterTest {
    @Test
    public void checkWhetherPrinterGetsCalled_DIYVersion() {
        Item[] items = {new Item("Jacket", 12.99)};
        Purchase purchase = new Purchase(items);
        MockPrinter mockPrinter = new MockPrinter();

        new CashRegister(mockPrinter).process(purchase);

        assertEquals(true, mockPrinter.isPrinterCalled());
    }

    @Test
    public void checkWhetherPrinterGetsPassedCorrectString_DIYVersion() {
        Item[] items = {new Item("Jacket", 12.99)};
        StubPurchase mockPurchase = new StubPurchase(items);
        MockPrinter mockPrinter = new MockPrinter();

        new CashRegister(mockPrinter).process(mockPurchase);

        assertEquals("happy testing!", mockPrinter.getPrintedString());
    }

    @Test
    public void checkWhetherPrinterGetsCalled_MockitoVersion() {
        Purchase mockPurchase = mock(Purchase.class);
        Printer mockPrinter = mock(Printer.class);

        new CashRegister(mockPrinter).process(mockPurchase);

        verify(mockPrinter, times(1)).print(mockPurchase.asString());
    }

    @Test
    public void checkWhetherPrinterGetsPassedCorrectString_MockitoVersion() {
        Purchase mockPurchase = mock(Purchase.class);
        when(mockPurchase.asString()).thenReturn("happy testing!");
        Printer mockPrinter = mock(Printer.class);
        // This seems to defeat the purpose of testing whether the string is passed to the printer or not
        when(mockPrinter.getPrintedString()).thenReturn("happy testing!");

        new CashRegister(mockPrinter).process(mockPurchase);

        assertEquals("happy testing!", mockPrinter.getPrintedString());
    }
}
