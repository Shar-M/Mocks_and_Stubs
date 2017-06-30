package cashregister;

public class MockPrinter extends Printer {
    boolean printStatus;
    private String printedString;

    public boolean isPrinterCalled() {
        return printStatus;
    }


    @Override
    public void print(String printThis) {
        printStatus = true;
        printedString = printThis;
    }

    public String getPrintedString() {
        return printedString;
    }
}
