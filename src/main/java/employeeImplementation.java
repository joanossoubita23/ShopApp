import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class employeeImplementation implements employeeCRUD {
    private Connection connection;

    public employeeImplementation(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addEmployee(employee employee) {
        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO employee(name,email,salary) VALUES(?,?,?)")){
            statement.setString(1,employee.getName());
            statement.setString(2,employee.getEmail());
            statement.setLong(3,employee.getSalary());
            statement.executeUpdate();
            System.out.println("Employee added successfully");
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public employee removeEmployee() {
        return null;
    }

    @Override
    public void updateEmployee(int id) {

    }

    @Override
    public List<employee> viewEmployee() {
        return null;
    }
}
