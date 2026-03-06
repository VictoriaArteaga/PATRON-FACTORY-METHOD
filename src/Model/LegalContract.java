package Model;

public class LegalContract extends DocumentProcessor {

    public LegalContract(String documentName, String format, User user) {
        super(documentName, format, user);
    }

    @Override
    protected void processDocument() {

        // validación jurídica del contrato

    }
}