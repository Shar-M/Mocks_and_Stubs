package cashregister;

public class MockPrinter extends Printer {
    boolean printStatus;

    public boolean hasPrinted() {
        return printStatus;
    }
    @Override
    public void print(String printThis) {
        printStatus = true;
    }
}
