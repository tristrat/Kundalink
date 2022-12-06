package com.example.kundalink2;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DBManager {
    public List<Todolist> loadTodolist() {
        List<Todolist> todolistAll = new ArrayList<Todolist>();
        Connection myConn = this.Connector();
        try {
            Statement myStmt = myConn.createStatement();
            String sql = "select * from student.todolist";
            ResultSet myRs = myStmt.executeQuery(sql);
            while (myRs.next()) {
                Todolist s = new Todolist(myRs.getInt("id"), myRs.getString("name"),
                        myRs.getDate("birth").toLocalDate(),
                        myRs.getString("comments")
                );

                todolistAll.add(s);
            }
            this.close(myConn, myStmt, myRs);
            return todolistAll;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Connection Connector() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Student? serverTimezone=Europe%2FParis", "root", "Cleo2508!");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
        try {
            if (myStmt != null) myStmt.close();
            if (myRs != null) myRs.close();
            if (myConn != null) myConn.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addTodolist(Todolist todolist) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = this.Connector();
            String Todolist = "INSERT INTO todolist (name,birth,comments) VALUES (?,?, ?)";
            myStmt = myConn.prepareStatement(Todolist);
            myStmt.setString(1, todolist.getName());

            myStmt.setString(2, String.valueOf(todolist.getBirth_date()));

            myStmt.setString(3, todolist.getComments());
            myStmt.execute();
            System.out.println("test1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close(myConn, myStmt, myRs);
        }

    }

    public void editTodolist(Todolist todolist, String newname, LocalDate newbirth, String newcomment) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = this.Connector();
            String sql = "UPDATE todolist SET name= ?,birth= ?,comments= ? WHERE id=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, newname);

            myStmt.setString(2, String.valueOf(newbirth));

            myStmt.setString(3, newcomment);
            myStmt.setString(4, String.valueOf(todolist.getId()));
            myStmt.execute();
            System.out.println(myStmt);
            System.out.println("test1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close(myConn, myStmt, myRs);
        }

    }

    public void deleteTodolist(Todolist todolist) {
        Connection myConn = null;
        PreparedStatement myStmt = null;
        ResultSet myRs = null;
        try {
            myConn = this.Connector();
            String sql = "DELETE FROM todolist WHERE id=?";
            myStmt = myConn.prepareStatement(sql);
            myStmt.setString(1, String.valueOf(todolist.getId()));
            myStmt.execute();
            System.out.println(myStmt);
            System.out.println("test1");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            close(myConn, myStmt, myRs);
        }
    }
}



