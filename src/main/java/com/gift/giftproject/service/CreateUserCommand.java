package com.gift.giftproject.service;

import lombok.NonNull;

public record CreateUserCommand(
        @NonNull String username,
        @NonNull String password
) {
}
