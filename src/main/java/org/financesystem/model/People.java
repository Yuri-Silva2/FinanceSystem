package org.financesystem.model;

import java.time.LocalDate;
import java.util.UUID;

public record People(UUID uuid, String user_name, String name, String email, LocalDate birthday, String password) { }
