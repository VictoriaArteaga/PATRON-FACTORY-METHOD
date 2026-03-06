package Model;

public abstract class DocumentProcessor {

    protected String documentName;
    protected String format;
    protected User user;

    public DocumentProcessor(String documentName, String format, User user) {
        this.documentName = documentName;
        this.format = format;
        this.user = user;
    }

    public void executeProcess() {

        validateFormat();
        processDocument();
        registerProcess();

    }

    protected void validateFormat(){

        if(format == null || format.isEmpty()){
            throw new IllegalArgumentException("Formato inválido");
        }

    }

    protected void registerProcess(){

    }

    protected abstract void processDocument();
}