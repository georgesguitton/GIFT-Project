package com.gift.giftproject.controller.command;

import java.sql.Date;

public record CreateStudentWithInternshipEntity(
        String firstname,
        String lastname,
        String group,
        String companyName,
        String companyAddress,
        String tutorName,
        Date startDate,
        Date endDate,
        String mission
) { }
