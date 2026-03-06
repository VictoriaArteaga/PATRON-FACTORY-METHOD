package Model;

public class FinancialReport extends DocumentProcessor {

    public FinancialReport(String documentName, String format, User user) {
        super(documentName, format, user);
    }

    @Override
    protected void processDocument() {

        // lógica de análisis financiero

    }
}