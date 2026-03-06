package Factory;
import Model.*;

public class ColombiFactory extends DocumentFactory {

    @Override
    public DocumentProcessor createDocument(
            String type,
            String name,
            String format,
            User user
    ) {

        switch(type){

            case "FACTURA":
                return new ElectronicInvoice(name, format, user, 1001);

            case "REPORTE":
                return new FinancialReport(name, format, user);

            case "CONTRATO":
                return new LegalContract(name, format, user);

            case "DECLARACION":
                return new TaxReturn(name, format, user);

            default:
                throw new IllegalArgumentException("Documento no soportado en Colombia");
        }

    }

}