package org.financesystem.session;

import java.io.*;
import java.util.Properties;

public class PropertiesSessionManager {

    private final Properties properties = new Properties();
    private final String filePath;

    public PropertiesSessionManager(String filePath) {
        this.filePath = filePath;
        loadProperties();
    }

    private void loadProperties() {
        try (InputStream input = new FileInputStream(filePath)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setAttribute(String key, String value) {
        properties.setProperty(key, value);
        saveProperties();
    }

    public String getAttribute(String key) {
        return properties.getProperty(key);
    }

    public void removeAttribute(String key) {
        properties.remove(key);
        saveProperties();
    }

    public void clearSession() {
        properties.clear();
        saveProperties();
    }

    private void saveProperties() {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
