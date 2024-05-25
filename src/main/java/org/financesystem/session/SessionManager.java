package org.financesystem.session;

import java.io.*;
import java.util.Properties;

/**
 * The SessionManager class provides methods for managing session attributes
 * using a properties file for storage. It allows setting, getting, removing,
 * and clearing session attributes.
 */
public class SessionManager {

    private final Properties properties = new Properties();
    private final File file;

    /**
     * Constructs a SessionManager with the specified file for storing session properties.
     *
     * @param file the file to use for storing session properties
     */
    public SessionManager(File file) {
        this.file = file;
        loadProperties();
    }

    /**
     * Loads the properties from a file.
     *
     * @throws RuntimeException if an I/O error occurs while loading the properties
     */
    private void loadProperties() {
        try (InputStream input = new FileInputStream(file)) {
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }


    /**
     * Sets an attribute in the session with the specified key and value.
     *
     * @param key   the key of the attribute
     * @param value the value of the attribute
     */
    public void setAttribute(String key, String value) {
        properties.setProperty(key, value);
        saveProperties();
    }

    /**
     * Gets the value of the attribute with the specified key from the session.
     *
     * @param key the key of the attribute
     * @return the value of the attribute, or null if the attribute does not exist
     */
    public String getAttribute(String key) {
        return properties.getProperty(key);
    }

    /**
     * Removes the attribute with the specified key from the session.
     *
     * @param key the key of the attribute to remove
     */
    public void removeAttribute(String key) {
        properties.remove(key);
        saveProperties();
    }

    /**
     * Clears all attributes from the session.
     */
    public void clearSession() {
        properties.clear();
        saveProperties();
    }

    /**
     * Saves the properties to a file.
     *
     * @throws RuntimeException if an I/O error occurs while saving the properties
     */
    private void saveProperties() {
        try (OutputStream output = new FileOutputStream(file)) {
            properties.store(output, null);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
