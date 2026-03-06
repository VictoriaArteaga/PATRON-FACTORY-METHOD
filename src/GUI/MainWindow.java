package GUI;

import Factory.*;
import Model.*;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private JComboBox<String> countryBox;
    private JComboBox<String> documentBox;
    private JTextField nameField;
    private JTextField formatField;
    private JButton processButton;

    public MainWindow(){

        setTitle("Sistema de Procesamiento de Documentos");
        setSize(400,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents(){

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,2,10,10));

        // País
        panel.add(new JLabel("País:"));

        countryBox = new JComboBox<>(new String[]{
                "COLOMBIA",
                "MEXICO",
                "ARGENTINA",
                "CHILE"
        });

        panel.add(countryBox);

        // Tipo documento
        panel.add(new JLabel("Tipo Documento:"));

        documentBox = new JComboBox<>(new String[]{
                "FACTURA",
                "REPORTE",
                "CONTRATO",
                "CERTIFICADO",
                "DECLARACION"
        });

        panel.add(documentBox);

        // Nombre documento
        panel.add(new JLabel("Nombre documento:"));
        nameField = new JTextField();
        panel.add(nameField);

        // Formato
        panel.add(new JLabel("Formato:"));
        formatField = new JTextField();
        panel.add(formatField);

        // Botón
        processButton = new JButton("Procesar Documento");
        panel.add(new JLabel());
        panel.add(processButton);

        add(panel);

        processButton.addActionListener(e -> processDocument());

    }

    private void processDocument(){

        try{

            String country = (String) countryBox.getSelectedItem();
            String type = (String) documentBox.getSelectedItem();
            String name = nameField.getText();
            String format = formatField.getText();

            User user = new User("1","Operador","Analista");

            DocumentFactory factory;

            switch(country){

                case "COLOMBIA":
                    factory = new ColombiFactory();
                    break;

                case "MEXICO":
                    factory = new MexicoDocumentFactory();
                    break;

                case "ARGENTINA":
                    factory = new ArgentinaDocumentFactory();
                    break;

                case "CHILE":
                    factory = new ChileDocumentFactory();
                    break;

                default:
                    throw new IllegalArgumentException("País no válido");
            }

            DocumentProcessor processor =
                    factory.createDocument(type,name,format,user);

            processor.executeProcess();

            JOptionPane.showMessageDialog(this,
                    "Documento procesado correctamente");

        }catch(Exception ex){

            JOptionPane.showMessageDialog(this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

}