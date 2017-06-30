package cashregister;

/**
 * Created by gesa on 30.06.17.
 */
public class StubPurchase extends Purchase {
    public StubPurchase(Item[] items) {
        super(items);
    }

    public String asString() {
        return "";
    }
}
