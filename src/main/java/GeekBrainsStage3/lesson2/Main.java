package GeekBrainsStage3.lesson2;

import java.sql.*;

public class Main {
    private static Connection connection;
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Для SQLite регистрация выглядит следующим образом:
        Class.forName("org.sqlite.JDBC");
        // Для H2 database - org.h2.Driver
        // Для MySql - com.mysql.jdbc.Driver
//        protocol: jdbc
//        subprotocol: sqlite
//        name: test.db
        Connection conn = DriverManager.getConnection("jdbc:sqlite:mydatabase.db");
//        ...Действия с БД...
//        conn.close();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        Statement updateStmt = conn.createStatement();
        int result = stmt.executeUpdate("INSERT INTO Students (Name, GroupName, Score) " +
                                            "VALUES (\"Bob\", \"Tbz11\", 80");

//        PreparedStatement ps = conn.prepareStatement("SELECT * FROM Students WHERE id = ? AND Score = ?");
//        ps.setInt(1, 2);
//        ps.setInt(2, 90);
//        ResultSet rs = ps.executeQuery();

        rs = stmt.executeQuery("SELECT * FROM users");
        while (rs.next()) {
            String name = rs.getString(2);    // Или rs.getString("Name");
            Integer score = rs.getInt("Score");
        }
        rs.first();         // перейти к первой строке
        rs.last();          // перейти к последней строке
        rs.next();          // перейти к следующей строке
        rs.previous();      // перейти к предыдущей строке

        conn.setAutoCommit(false);
        Statement st = conn.createStatement();
        try {
            st.execute("INSERT INTO user(Name) values(Kesha)");
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        }
    }

    private static void psBatchEx() {
        try (PreparedStatement prepInsert = connection.prepareStatement("INSERT INTO students (Name, Score) VALUES (?, ?")) {
            for (int i = 1;  i <= 10; i++) {
                prepInsert.setString(1, "Bob" + i);
                prepInsert.setInt(2, i * 10 % 100);
                prepInsert.addBatch();
            }
            int[] result = prepInsert.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void stmtBatch() {
        try {
            for (int i = 1; i<= 10; i++) {
                Statement stmt = connection.createStatement();
                stmt.addBatch(String.format("INSERT INTO students (Name, Score) VALUES (%s, %d)", "Bob" + i, i * 10 % 100));
                int[] result = stmt.executeBatch();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
