package Factory;

import Model.*;

public abstract class DocumentFactory {

    public abstract DocumentProcessor createDocument(
            String type,
            String name,
            String format,
            User user
    );

}