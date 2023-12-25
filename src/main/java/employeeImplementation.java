import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class employeeImplementation implements employeeCRUD {
    private Connection connection;

    public employeeImplementation(Connection connection) {
        this.connection = connection;
    }

    public employeeImplementation() {

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
    public employee removeEmployeeid(int id) {
        try (PreparedStatement statement= connection.prepareStatement("DELETE FROM employee WHERE id=?")) {
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("Employee Successfully Removed");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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


