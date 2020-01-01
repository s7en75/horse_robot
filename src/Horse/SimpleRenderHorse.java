package Horse;

import java.io.File;

import com.docmosis.SystemManager;
import com.docmosis.document.DocumentProcessor;
import com.docmosis.template.population.DataProviderBuilder;
import com.docmosis.util.Configuration;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.com.docmosis.JSONException;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * A simple example showing Docmosis creating a PDF with dynamic data from a DOC
 * template.
 */
public class SimpleRenderHorse {

    public static void main(String[] args) {

        String key = new String("0NAD-KLWL-JALO-DLIA-EBDH-1ELH-YBKQ-FS91-23ED-8-4A64");
        String site = new String("Free Trial License");
        String officePath = new String("C:\\Program Files\\LibreOffice");

        if (key.startsWith("XXXX")) {
            System.err.println("\nPlease set your license key");
            System.exit(1);
        }
        if (!new File(officePath).isDirectory() || !new File(officePath).canRead()) {

            System.err.println("\nPlease check \"officePath\" is set to the "
                    + "install dir for OpenOffice or LibreOffice");
            System.exit(1);
        }

        // Create the initialisation configuration
        Configuration config = new Configuration(key, site, officePath);

        // Tell Docmosis to use one embedded converter
        config.setConverterPoolConfiguration("1");

        // Use the DataProviderBuilder to build the data provider from a String array.
        DataProviderBuilder dpb = new DataProviderBuilder();
        try {
            dpb.addJSONFile(new File("C:\\Users\\a5\\Documents\\NetBeansProjects\\Tafkik\\TablesPartOne\\data.json"));
        } catch (IOException ex) {
            Logger.getLogger(SimpleRenderHorse.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(SimpleRenderHorse.class.getName()).log(Level.SEVERE, null, ex);
        }
//        dpb.add("date", "12 Nov 2015");
//        dpb.add("message", "This is Mohsen!");
//        dpb.add("date", "12 Nov 2015");
//        dpb.add("message", "This is Mohsen!");

        try {

            // Initialise the system based on configuration
            SystemManager.initialise(config);

            File templateFile = new File("test.docx");
            File outputFile = new File("E:\\Horse\\Horse.docx");

            if (!templateFile.canRead()) {
                System.err.println("\nCannot find '" + templateFile + "' in: " + new File("").getCanonicalPath());
            } else {

                // Create the document
                DocumentProcessor.renderDoc(templateFile, outputFile, dpb.getDataProvider());

                System.out.println("\nCreated: " + outputFile.getCanonicalPath());
            }
        } catch (Exception e) {
            System.err.println("\nPlease check the following: " + e.getMessage());
        } finally {
            // shutdown the system
            SystemManager.release();
        }
    }
}
