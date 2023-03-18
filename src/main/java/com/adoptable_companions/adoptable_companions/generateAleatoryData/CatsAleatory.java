package com.adoptable_companions.adoptable_companions.generateAleatoryData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.github.javafaker.Faker;

public class CatsAleatory {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/adoptable_companions?serverTimezone=Europe/Madrid&useSSL=false";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

        Faker faker = new Faker();

        for (int i = 0; i < 10; i++) {
            String name = faker.cat().name();
            String chipId = faker.number().digits(8);
            String race = faker.cat().breed();

            String sql = "INSERT INTO cat (name, chip_id, race) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, chipId);
            statement.setString(3, race);
            statement.executeUpdate();
        }

        connection.close();
    }
}
