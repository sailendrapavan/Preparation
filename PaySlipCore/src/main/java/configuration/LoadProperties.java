package configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadProperties extends Properties {    

    private static Logger log = LoggerFactory.getLogger(LoadProperties.class);

    public LoadProperties() {
        loadPropertiesFromFile();
    }

    public void loadPropertiesFromFile() {

        InputStream is = getClass().getResourceAsStream("/PaySlipGenerator.properties");
        Properties propertiesFromFile = new Properties();
        if (is != null) {
            try {
                propertiesFromFile.load(is);
                for (Map.Entry<Object, Object> entry : propertiesFromFile.entrySet()) {
                    String propName = ((String) entry.getKey()).trim();
                    String propValue = ((String) entry.getValue()).trim();

                    super.setProperty(propName, propValue);
                }
            } catch (IOException e) {
                log.error("Exception while reading properties from file", e);
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    log.error("Unable to close Input Stream!!");
                }
            }

        } else {
            throw new RuntimeException("Unable to find PaySlip.properties");
        }

    }
}
