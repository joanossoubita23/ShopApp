import java.util.List;

public interface employeeCRUD {
    void addEmployee(employee employee);
    employee removeEmployeeid(int id);
    void updateEmployee(int id);
    List<employee> viewEmployee();
}
