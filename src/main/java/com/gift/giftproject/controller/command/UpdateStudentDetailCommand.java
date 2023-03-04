package com.gift.giftproject.controller.command;

import java.sql.Date;

public record UpdateStudentDetailCommand(
        String firstname,
        String lastname,
        String group,
        String companyName,
        String companyAddress,
        String tutorName,
        Date startDate,
        Date endDate,
        String mission,
        boolean specDone,
        boolean visitFormDone,
        boolean companyFormDone,
        boolean webPollDone,
        boolean reportDone,
        String comments,
        boolean visitPlaned,
        boolean visitDone,
        double technicalGrade,
        double communicationGrade,
        boolean oralPresentationDone
        ) { }
