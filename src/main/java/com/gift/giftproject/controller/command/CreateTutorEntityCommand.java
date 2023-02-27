package com.gift.giftproject.controller.command;

public record CreateTutorEntityCommand(
        String email,
        String firstname,
        String lastname,
        String password
) { }
