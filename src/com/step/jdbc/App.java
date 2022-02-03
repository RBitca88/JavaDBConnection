package com.step.jdbc;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        EmployeeDao dao = new EmployeeDao();

        //save
        dao.create(new Employee("Igor", "Avornic"));
        dao.create(new Employee("Viorica", "Marinescu"));

       // get all
        List<Employee> employeeList = dao.readAll();
        for (Employee emp: dao.readAll()) {
            System.out.println(emp);
        }

        //update
        //dao.update(5, "Igor", "Avornic");
        dao.update(new Employee(5, "Igor", "Avornic"));

        //delete
        //dao.delete(5);
        dao.delete(employeeList.get(4));
    }
}
