package org.financesystem.controller;

import org.financesystem.Main;
import org.financesystem.service.AlertService;
import org.financesystem.session.SessionManager;

import java.io.File;
import java.util.UUID;

/**
 * The FormController class handles the logic for user login, signup, and session management in the Finance System application.
 */
public class FormController {

    private final AlertService alertService;
    private final SessionManager sessionManager;

    /**
     * Constructs a FormController with the specified SessionManager and AlertService.
     *
     * @param sessionManager the session manager to handle session properties
     * @param alertService   the alert service to display error messages
     */
    public FormController(SessionManager sessionManager, AlertService alertService) {
        File sessionDir = new File(System.getProperty("user.home") + "\\Documents\\FinanceSystem");
        if (!sessionDir.exists()) sessionDir.mkdirs();

        this.sessionManager = sessionManager;
        this.alertService = alertService;
    }

    /**
     * Handles the logic for a successful login. Saves the session properties if auto session is enabled.
     *
     * @param uuid        the user's unique identifier
     * @param autoSession whether to save session properties for automatic login
     */
    public void successfulLogin(String uuid, boolean autoSession) {
        if (autoSession)
            saveSessionProperties(uuid);

        Main.showFinanceDashboard();
    }

    /**
     * Automatically logs in the user if a session already exists.
     */
    public void autoLogin() {
        if (alreadyLoggedInSession())
            Main.showFinanceDashboard();
    }

    /**
     * Handles the logic for a successful signup.
     */
    public void successfulSignUp() {
        Main.showFinanceDashboard();
    }

    public UUID getIDLoggedSession() {
        return UUID.fromString(sessionManager.getAttribute("session"));
    }

    /**
     * Checks if a session already exists.
     *
     * @return true if a session exists, false otherwise
     */
    private boolean alreadyLoggedInSession() {
        return sessionManager.getAttribute("session") != null;
    }

    /**
     * Saves the session properties for the specified user UUID.
     *
     * @param uuid the user's unique identifier
     */
    private void saveSessionProperties(String uuid) {
        sessionManager.setAttribute("session", uuid);
    }

    /**
     * Sends an error message using the alert service.
     *
     * @param errorMessage the error message to be displayed
     */
    public void sendFormErrorMessage(String errorMessage) {
        alertService.showAlert("Error", errorMessage);
    }
}
