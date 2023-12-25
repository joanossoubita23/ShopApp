import java.util.List;

public interface employeeCRUD {
    void addEmployee(employee employee);
    employee removeEmployee();
    void updateEmployee(int id);
    List<employee> viewEmployee();
}
