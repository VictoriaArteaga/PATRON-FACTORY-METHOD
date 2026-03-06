package Model;

import model.User;

public class ElectronicInvoice extends DocumentProcessor {

    private int invoiceNumber;

    public ElectronicInvoice(String documentName,
                            String format,
                            User user,
                            int invoiceNumber) {

        super(documentName, format, user);
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    protected void processDocument() {

        // lógica de procesamiento real

        if(invoiceNumber <= 0){
            throw new IllegalArgumentException("Número de factura inválido");
        }

        // validación tributaria
        // cálculo de impuestos
        // validación de estructura XML

    }

}