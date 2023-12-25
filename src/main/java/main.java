import java.util.Scanner;

public class main {
    static employeeCRUD employeeCRUD=new employeeImplementation(JDBConnection.getConnection());
    static employeeImplementation employeeImplementation=new employeeImplementation();
    public static void main(String[] args) {
        //employeeCRUD employeeCRUD=new employeeImplementation(JDBConnection.getConnection());
        Scanner sc =new Scanner(System.in);
        boolean option =true;
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
                5-view all employee
                6-Exit thank you for passing by
                
                """);
                choice=sc.nextInt();
switch (choice){
    case 1:
        employee employee=insertEmployee(sc);
        employeeCRUD.viewEmployee();
        employeeCRUD.addEmployee(employee);
        break;
    case 2:
        break;
    case 3:
        break;
    case 4:
        break;
    case 5:
        break;
    case 6:
        System.out.println("Thank you for passing bye");
        option=false;
        break;
}}while (choice!=6);
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
        employee employeeList=new employee(name,email,salary);
       // employeeCRUD.addEmployee(employeeList);
        return (employeeList);



    }}
