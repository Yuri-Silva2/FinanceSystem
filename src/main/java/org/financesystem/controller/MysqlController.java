package org.financesystem.controller;

import org.financesystem.model.People;
import org.financesystem.repository.PeopleRepository;
import org.financesystem.service.MysqlService;
import org.jetbrains.annotations.NotNull;

/**
 * The MysqlController class is responsible for managing the interactions
 * with the PeopleRepository, including initializing the repository and
 * performing CRUD operations on People objects.
 */
public class MysqlController {

    private PeopleRepository peopleRepository;

    /**
     * Initializes the MysqlController by setting up the MysqlService and
     * PeopleRepository.
     * This method should be called to prepare the controller for use.
     */
    public void initialize() {
        MysqlService mysqlService = new MysqlService();
        peopleRepository = new PeopleRepository(mysqlService.getDataSource());
    }

    /**
     * Creates a new People entry in the repository.
     *
     * @param people the People object containing the data to be stored.
     */
    public void createPeople(@NotNull People people) {
        peopleRepository.createPeople(people.uuid(), people.email(), people.password());
    }

    /**
     * Checks if a People entry with the given email exists in the repository.
     *
     * @param email the email to check for existence.
     * @return a String indicating whether the People entry exists.
     */
    public String containsPeople(String email) {
        return peopleRepository.containsPeople(email);
    }

    /**
     * Retrieves the ID of a People entry based on the given email.
     *
     * @param email the email to search for.
     * @return the ID associated with the given email.
     */
    public String getIdByEmail(String email) {
        return peopleRepository.getIdByEmail(email);
    }
}
