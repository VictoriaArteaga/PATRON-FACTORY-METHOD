package Factory;

import Model.*;

public class MexicoDocumentFactory extends DocumentFactory {

    @Override
    public DocumentProcessor createDocument(
            String type,
            String name,
            String format,
            User user
    ) {

        switch(type){

            case "FACTURA":
                return new ElectronicInvoice(name, format, user, 2001);

            case "CONTRATO":
                return new LegalContract(name, format, user);

            case "CERTIFICADO":
                return new DigitalCertificate(name, format, user);

            default:
                throw new IllegalArgumentException("Documento no soportado en México");
        }

    }

}