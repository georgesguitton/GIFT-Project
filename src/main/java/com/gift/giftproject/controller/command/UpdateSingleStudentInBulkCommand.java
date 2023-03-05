package com.gift.giftproject.controller.command;

public record UpdateSingleStudentInBulkCommand(
        boolean specDone,
        boolean visitFormDone,
        boolean companyFormDone,
        boolean webPollDone,
        boolean reportDone,
        boolean visitPlaned,
        boolean visitDone
) { }
