import java.util.Scanner;

public interface employeeCRUD {
    void addEmployee(employee employee);
    employee removeEmployeeid(int id);
    void updateEmployee(int id);

    void updateEmployee(int id, employee employee);

    Scanner viewEmployee();
}
