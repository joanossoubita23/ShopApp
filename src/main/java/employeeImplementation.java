import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class employeeImplementation implements employeeCRUD {
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
    public void updateEmployee(int id, employee employee) {
        try (PreparedStatement statement= connection.prepareStatement("UPDATE employee SET id=? name= ? email=? salary=? WHERE id=?")){
            statement.setInt(1,employee.getId());
            statement.setString(2,employee.getName());
            statement.setString(3,employee.getEmail());
            statement.setLong(4,employee.getSalary());
            statement.executeUpdate();
            System.out.println("Employee Successfully Update");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public Scanner viewEmployee() {
        List<employee> employeeList=new ArrayList<>();
        try (PreparedStatement statement=connection.prepareStatement("SELECT *FROM employee")){
            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()){
                    int id =rs.getInt("id");
                    String name=rs.getString("name");
                    String email=rs.getString("email");
                    long salary=rs.getLong("salary");
                    employee employee=new employee(name,email,salary);
                    employeeList.add(employee);
                }

            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;

    }



    }


