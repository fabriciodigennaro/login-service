package com.parkingapp.userservice.application.login;

import com.parkingapp.userservice.domain.auth.AuthTokenGenerator;
import com.parkingapp.userservice.domain.exceptions.InvalidCredentialsException;
import com.parkingapp.userservice.domain.service.PasswordEncryptor;
import com.parkingapp.userservice.domain.user.User;
import com.parkingapp.userservice.domain.user.UsersRepository;

import java.util.Optional;

public class LoginUseCase {
    private final AuthTokenGenerator authTokenGenerator;
    private final UsersRepository usersRepository;
    private  final PasswordEncryptor passwordEncryptor;

    public LoginUseCase(
        AuthTokenGenerator authTokenGenerator,
        UsersRepository usersRepository,
        PasswordEncryptor passwordEncryptor
    ) {
        this.authTokenGenerator = authTokenGenerator;
        this.usersRepository = usersRepository;
        this.passwordEncryptor = passwordEncryptor;
    }

    public LoginResponse execute(String email, String password) {
        Optional<User> user = usersRepository.getUserByEmail(email);

        if (user.isPresent() && credentialsMatch(password, user.get())) {
            Token token = new Token(authTokenGenerator.generateToken(email));
            RefreshToken refreshToken = new RefreshToken(authTokenGenerator.generateRefreshToken(email));

            return new LoginResponse(token, refreshToken);
        }
        throw new InvalidCredentialsException();
    }

    private boolean credentialsMatch(String password, User user) {
        return passwordEncryptor.matches(password, user.getPassword());
    }
}
