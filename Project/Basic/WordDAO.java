package com.Project.Basic;

import com.Project.BUS_BOOKING_SYSTEM.User;
import com.Project.FIle_Encrypt.EncryptionV1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WordDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/words";
    private  String USER = "_0:1!|?>|?>|%#3$|";
    private  String PASSWORD = "65%4|1/12|65%4|1/12|&9$<|S64|N8|N6|N6|N7|&34^~|)99&|~12#|198&5%|@12$9&|1/12|";


    private Connection getConnection() throws SQLException {
        EncryptionV1 v=new EncryptionV1();
        String u=v.decrypt(USER);
        String p=v.decrypt(PASSWORD);
        return DriverManager.getConnection(URL, u, p);
    }

    public List<String> getSuggestions(String prefix) {
        List<String> suggestions = new ArrayList<>();
        String query = "SELECT word FROM words WHERE word LIKE ? ORDER BY popularity DESC LIMIT 5";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, prefix + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                suggestions.add(rs.getString("word"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return suggestions;
    }

    public void increasePopularity(String word) {
        String updateQuery = "UPDATE words SET popularity = popularity + 1 WHERE word = ?";
        String insertQuery = "INSERT INTO words (word, popularity) VALUES (?, 1)";

        try (Connection conn = getConnection();
             PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {

            updateStmt.setString(1, word);
            int rowsAffected = updateStmt.executeUpdate();

            // If word doesn't exist, insert it
            if (rowsAffected == 0) {
                try (PreparedStatement insertStmt = conn.prepareStatement(insertQuery)) {
                    insertStmt.setString(1, word);
                    insertStmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        WordDAO dao = new WordDAO();

        // Example: User types "th"
        List<String> suggestions = dao.getSuggestions("th");
        System.out.println("Suggestions for 'th': " + suggestions);

        // Example: User selects "the"
        dao.increasePopularity("the");
        System.out.println("'the' popularity updated!");
    }
}
