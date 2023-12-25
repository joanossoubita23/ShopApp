import java.sql.SQLException;
import java.util.Scanner;

public class main {
    static employeeCRUD employeeCRUD = new employeeImplementation(JDBConnection.getConnection()) {
        @Override
        public void updateEmployee(int id) {

        }
    };
    static employeeImplementation employeeImplementation = new employeeImplementation() {
        @Override
        public void updateEmployee(int id) {

        }
    };

    public static void main(String[] args) {
        //employeeCRUD employeeCRUD=new employeeImplementation(JDBConnection.getConnection());
        Scanner sc = new Scanner(System.in);
        boolean option = true;
        int choice;
        try {
            do {
                System.out.println("""
                        Welcome to our employee Application
                        choose from the following
                        1-add an employee
                        2-Update employee
                        3-delete employee
                        4- view employee
                        5-Exit thank you for passing by
                          """);
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        employee employee = insertEmployee(sc);
                        employeeCRUD.viewEmployee();
                        employeeCRUD.addEmployee(employee);
                        break;
                    case 2:
                        employeeCRUD.viewEmployee();
                        sc.nextLine();
                        System.out.println("Enter employee to Update");
                        int id2 = sc.nextInt();
                        System.out.println("Enter the new employee information");

                        break;
                    case 3:
                        employeeCRUD.viewEmployee();
                        sc.nextLine();
                        System.out.println("Please enter Id to delete");
                        int id = sc.nextInt();
                        employeeCRUD.removeEmployeeid(id);
                        break;
                    case 4:
                        System.out.println("Here is List of employee");
                        viewEmployee(employeeCRUD.viewEmployee());
                        break;
                    case 5:
                        System.out.println("Thank you for passing bye");
                        option = false;
                        break;
                }
            } while (choice != 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static employee insertEmployee(Scanner sc) {
        System.out.println("Please enter the name of the employee ");
        String name = sc.next();  // Read the name

        System.out.println("Please enter the email you want to add");
        String email = sc.next();  // Read the email
        System.out.println("Please enter the salary");
        long salary = sc.nextLong();  // Read the salary
        employee employeeList = new employee(name, email, salary);
        // employeeCRUD.addEmployee(employeeList);
        return (employeeList);


    }

    private static void viewEmployee(Scanner sc) throws SQLException {
        for (Scanner it = employeeCRUD.viewEmployee(); it.hasNext(); ) {
            String employee = it.next();
            System.out.println(employee.toString());
        }

    }
}
