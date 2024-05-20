package org.financesystem.model;

import java.time.LocalDate;

public record People(String name, String email, LocalDate birthday, String password) { }
