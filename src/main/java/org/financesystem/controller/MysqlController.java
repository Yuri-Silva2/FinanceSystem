package org.financesystem.controller;

import org.financesystem.model.People;
import org.financesystem.repository.PeopleRepository;
import org.financesystem.service.MysqlService;

public class MysqlController {

    private static PeopleRepository peopleRepository;

    public static void initialize() {
        MysqlService mysqlService = new MysqlService();
        peopleRepository = new PeopleRepository(mysqlService.getDataSource());
    }

    protected static void createPeople(People people) {
        peopleRepository.createPeople(people.uuid(), people.email(), people.password());
    }

    protected static String containsPeople(String email) {
        return peopleRepository.containsPeople(email);
    }

    protected static String getIdByEmail(String email) {
        return peopleRepository.getIdByEmail(email);
    }
}
