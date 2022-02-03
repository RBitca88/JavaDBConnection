package com.step.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao { //Dao - data access object

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/manager", "postgres", "RB1988");
        return connection;
    }

    //create
    public void create(Employee employee) throws SQLException {
        Connection connection = getConnection();
        //String insert = "INSERT INTO app.employee(name, surname) values('"+employee.getName()+"', '"+employee.getSurname()+"')";
        String insert = "INSERT INTO app.angajati(name, surname) values(?,?)";
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, employee.getName());
        statement.setString(2, employee.getSurname());

        int row = statement.executeUpdate();
        if (row == 0) {
            System.out.println("Eroare: " + row + "randuri au fost modificate");
        }
        statement.close();
        connection.close();
    }

    //get all
    public List<Employee> readAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        Connection connection = getConnection();
        String select = "SELECT id, name, surname FROM app.angajati";

        PreparedStatement statement = connection.prepareStatement(select);
        ResultSet result = statement.executeQuery();

        while(result.next()){
            int id = result.getInt("id");
            String name = result.getString("name");
            String surname = result.getString("surname");
            employees.add(new Employee(id, name, surname));
        }
        statement.close();
        connection.close();
        return employees;
    }
    //update
//    public void update(int id, String name, String surname) throws SQLException {
//        Connection connection = getConnection();
//        String update = "Update app.angajati set name = ?, surname = ? where id = ?";
//        PreparedStatement statement = connection.prepareStatement(update);
//        statement.setString(1, name);
//        statement.setString(2, surname);
//        statement.setInt(3, id);
//        statement.executeUpdate();
//        statement.close();
//        connection.close();
//    }
    public void update(Employee emp) throws SQLException {
        Connection connection = getConnection();
        String update = "Update app.angajati set name = ?, surname = ? where id = ?";
        PreparedStatement statement = connection.prepareStatement(update);
        statement.setString(1, emp.getName());
        statement.setString(2, emp.getSurname());
        statement.setInt(3, emp.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }

    //delete
//    public void delete(int id) throws SQLException {
//        Connection connection = getConnection();
//        String delete = "delete from app.angajati where id = ?";
//        PreparedStatement statement = connection.prepareStatement(delete);
//        statement.setInt(1, id);
//        statement.executeUpdate();
//        statement.close();
//        connection.close();
//    }
    public void delete(Employee emp) throws SQLException {
        Connection connection = getConnection();
        String delete = "delete from app.angajati where id = ?";
        PreparedStatement statement = connection.prepareStatement(delete);
        statement.setInt(1, emp.getId());
        statement.executeUpdate();
        statement.close();
        connection.close();
    }


}
