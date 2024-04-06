package com.DmiFinance.BitBlazers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class JsonXmlParser {


    public static void db(String jsonString) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/bitblazers";
        String username = "postgres";
        String password = "password";

        try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            String createTable= "CREATE TABLE products (id SERIAL PRIMARY KEY, product_info jsonb)";
            conn.prepareStatement(createTable).execute();
//            smt.execute(createTable);

            String sql = "INSERT INTO products (product_info) VALUES (?::jsonb)";

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, jsonString);
                stmt.executeUpdate();
                System.out.println("JSON data inserted successfully");
            }
            catch (SQLException e) {
                System.err.println("Error during insertion: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
        }
    }



    public static void tryfunc() {
        System.out.println("checking try function");
    }

    public static void readFiles(String path) throws IOException, SQLException {
        File file = new File(path);

        if (file.isFile()) {
            // Process the file

            // Dynamic Json parsing without creating class
            ObjectMapper jsonMapper = new ObjectMapper();

            Map<String, Object> data1 = jsonMapper.readValue(file, Map.class);
            String jsonString1 = jsonMapper.writeValueAsString(data1);

            boolean ans1 = isValid(jsonString1);
            System.out.println(file.getName()); // Example
            System.out.println("json is " + ans1);

            if(ans1){
             db(jsonString1);
            }

        }

    }


    public static boolean isValid(String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.readTree(json);

        } catch (JacksonException e) {
            return false;
        }
        return true;
    }


}