package ru.egartech;

public class ProfileRepo {

    private final String jdbcUrl;

    public ProfileRepo(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public void printJdbcUrl() {
        System.out.println(jdbcUrl);
    }

    //somework with db
}
