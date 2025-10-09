# OIDC Test Application

This project is a test client for the OIDC backend, used to verify authentication and token flows.

## Features

- Simple web UI for testing OIDC login and userinfo endpoints
- Displays user claims and session info
- Supports logout

## Structure

- `src/main/resources/templates/` - Thymeleaf HTML templates
- `src/main/java/com/example/oidctest/` - Test application source code

## Running

```sh
mvn clean install
mvn spring-boot:run
```

## Usage

- Visit `/` to start authentication
- After login, user info and claims are displayed

## Notes

- Intended for development and integration testing
- Requires backend and frontend to be running

