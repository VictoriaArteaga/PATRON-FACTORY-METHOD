package Model;

public class TaxReturn extends DocumentProcessor {

    public TaxReturn(String documentName, String format, User user) {
        super(documentName, format, user);
    }

    @Override
    protected void processDocument() {

        // validación tributaria

    }
}