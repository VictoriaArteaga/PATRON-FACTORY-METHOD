package Model;

public class DigitalCertificate extends DocumentProcessor {

    public DigitalCertificate(String documentName, String format, User user) {
        super(documentName, format, user);
    }

    @Override
    protected void processDocument() {

        // validación de firma digital

    }
}