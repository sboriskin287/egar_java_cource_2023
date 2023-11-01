package ru.egartech.starter;

public class ProfileService {

    private final String jdbcUrl;

    public ProfileService(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void printJdbc() {
        System.out.println(jdbcUrl);
    }
}
