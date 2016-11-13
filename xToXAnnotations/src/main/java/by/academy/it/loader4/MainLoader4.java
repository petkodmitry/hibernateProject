package by.academy.it.loader4;

import by.academy.it.db4.*;
import by.academy.it.pojos4.*;
import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.Set;

public class MainLoader4 {
    private static Logger log = Logger.getLogger(MainLoader4.class);
    private static EmployeeOneOneADao employeeOneOneADao = EmployeeOneOneADao.getInstance();
    private static DepartmentOneOneADao departmentOneOneADao = DepartmentOneOneADao.getInstance();
    private static EmployeeOneManyADao employeeOneManyADao = EmployeeOneManyADao.getInstance();
    private static DepartmentOneManyADao departmentOneManyADao = DepartmentOneManyADao.getInstance();
    private static EmployeeManyManyADao employeeManyManyADao = EmployeeManyManyADao.getInstance();
    private static MeetingManyManyADao meetingManyManyADao = MeetingManyManyADao.getInstance();

    public static void main(String args[]) throws DaoException4 {
        EmployeeOneOneA employeeOneOneA = null;
        EmployeeOneManyA employeeOneManyA = null;
        EmployeeManyManyA employeeManyManyA = null;

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0); break;

                case 1:
                    employeeOneOneA = createEmployeeOne(employeeOneOneA);
                    System.out.println(employeeOneOneA);
                    break;
                case 2:
                    employeeOneOneA = getEmployeeOne(employeeOneOneA);
                    System.out.println(employeeOneOneA);
                    break;
                case 3:
                    employeeOneOneA = updateEmployeeOne(employeeOneOneA);
                    System.out.println(employeeOneOneA);
                    break;
                case 4:
                    deleteEmployeeOne(employeeOneOneA);
                    break;

                case 11:
                    employeeOneManyA = createEmployeeMany(employeeOneManyA);
                    System.out.println(employeeOneManyA);
                    break;
                case 12:
                    employeeOneManyA = getEmployeeMany(employeeOneManyA);
                    System.out.println(employeeOneManyA);
                    break;
                case 13:
                    employeeOneManyA = updateEmployeeMany(employeeOneManyA);
                    System.out.println(employeeOneManyA);
                    break;
                case 14:
                    deleteEmployeeMany(employeeOneManyA);
                    break;

                case 21:
                    employeeManyManyA = createEmployeeManyMany(employeeManyManyA);
                    System.out.println(employeeManyManyA);
                    break;
                case 22:
                    employeeManyManyA = getEmployeeManyMany(employeeManyManyA);
                    System.out.println(employeeManyManyA);
                    break;
                case 23:
                    employeeManyManyA = updateEmployeeManyMany(employeeManyManyA);
                    System.out.println(employeeManyManyA);
                    break;
                case 24:
                    deleteEmployeeManyMany(employeeManyManyA);
                    break;

                default:
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println(" Options:");
        System.out.println("        0. Exit");
        System.out.println();
        System.out.println("        1. Create EmployeeOneOneA+DepartmentOneOneA");
        System.out.println("        2. Read(Get) EmployeeOneOneA+DepartmentOneOneA");
        System.out.println("        3. Update EmployeeOneOneA+DepartmentOneOneA");
        System.out.println("        4. Delete EmployeeOneOneA+DepartmentOneOneA");
        System.out.println();
        System.out.println("        11. Create EmployeeOneManyA+DepartmentOneManyA");
        System.out.println("        12. Read(Get) EmployeeOneManyA+DepartmentOneManyA");
        System.out.println("        13. Update EmployeeOneManyA+DepartmentOneManyA");
        System.out.println("        14. Delete EmployeeOneManyA+DepartmentOneManyA");
        System.out.println();
        System.out.println("        21. Create EmployeeManyManyA+MeetingManyManyA");
        System.out.println("        22. Read(Get) EmployeeManyManyA+MeetingManyManyA");
        System.out.println("        23. Update EmployeeManyManyA+MeetingManyManyA");
        System.out.println("        24. Delete EmployeeManyManyA+MeetingManyManyA");
    }

    public static EmployeeOneOneA createEmployeeOne(EmployeeOneOneA employee) throws DaoException4 {
        System.out.println("Creating EmployeeOneOneA:");
        System.out.print("Name - ");
        /*if(person == null) {*/employee = new EmployeeOneOneA();/*}*/
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        employee.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        employee.setSurname(parameter);

        DepartmentOneOneA details = new DepartmentOneOneA();
        System.out.print("Street - ");
        details.setStreet(scanner.nextLine());
        System.out.print("City - ");
        details.setCity(scanner.nextLine());
        System.out.print("State - ");
        details.setState(scanner.nextLine());

        details.setEmployee(employee);
        employee.setDetails(details);

        employeeOneOneADao.saveOrUpdate(employee);
        return employee;
    }

    public static EmployeeOneOneA getEmployeeOne (EmployeeOneOneA employee) throws DaoException4 {
        System.out.println("Get EmployeeOneOneA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneOneADao.get(id);
        return employee;
    }

    public static EmployeeOneOneA updateEmployeeOne (EmployeeOneOneA employee) throws DaoException4 {
        System.out.println("Update EmployeeOneOneA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneOneADao.get(id);

        System.out.print("Set new CITY - ");
        scanner = new Scanner(System.in);
        employee.getDetails().setCity(scanner.nextLine());

        employeeOneOneADao.saveOrUpdate(employee);
        return employee;
    }

    public static void deleteEmployeeOne (EmployeeOneOneA employee) throws DaoException4 {
        System.out.println("Delete EmployeeOneOneA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneOneADao.get(id);
        try {
            employeeOneOneADao.delete(employee);
        } catch (DaoException4 e) {
            System.out.println("No such EmployeeOneOneA in DataBase!");
        }
    }

    public static DepartmentOneManyA createNewDepartment(String name) {
        DepartmentOneManyA dep = new DepartmentOneManyA();
        dep.setDepName(name);
        return dep;
    }

    public static EmployeeOneManyA createEmployeeMany(EmployeeOneManyA employee) throws DaoException4 {
        System.out.println("Please enter department description:");
        System.out.print("Department Id - ");

        Scanner scanner = new Scanner(System.in);
        DepartmentOneManyA department = departmentOneManyADao.get(scanner.nextInt());
        if (department == null) {
            System.out.println("Department doesn't exist. Please enter a new Department NAME - ");
            scanner = new Scanner(System.in);
            department = createNewDepartment(scanner.nextLine());
        }

        System.out.println("Please enter employee description:");
        System.out.print("Name - ");
        /*if(person == null) {*/employee = new EmployeeOneManyA();/*}*/
        scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        employee.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        employee.setSurname(parameter);

        employee.setDepartment(department);
        department.getEmployees().add(employee);

        employeeOneManyADao.saveOrUpdate(employee);

        return employee;
    }

    public static EmployeeOneManyA getEmployeeMany (EmployeeOneManyA employee) throws DaoException4 {
        System.out.println("Get EmployeeOneManyA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneManyADao.get(id);
        return employee;
    }

    public static EmployeeOneManyA updateEmployeeMany (EmployeeOneManyA employee) throws DaoException4 {
        System.out.println("Update EmployeeOneManyA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneManyADao.get(id);

        System.out.print("Set new NAME - ");
        scanner = new Scanner(System.in);
        employee.setName(scanner.nextLine());

        employeeOneManyADao.saveOrUpdate(employee);
        return employee;
    }

    public static void deleteEmployeeMany (EmployeeOneManyA employee) throws DaoException4 {
        System.out.println("Delete EmployeeOneManyA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneManyADao.get(id);
        if (employee != null) {
            Set<EmployeeOneManyA> set = employee.getDepartment().getEmployees();
            System.out.println("department.size() = " + set.size());
            set.remove(employee);
            employeeOneManyADao.delete(employee);
            System.out.println("department.size() = " + set.size());
        } else {
            System.out.println("No such EmployeeOneManyA in DataBase!");
        }
    }

    public static MeetingManyManyA createNewMeeting(String name) {
        MeetingManyManyA dep = new MeetingManyManyA();
        dep.setSubject(name);
        return dep;
    }

    public static EmployeeManyManyA createEmployeeManyMany(EmployeeManyManyA employee) throws DaoException4 {
        System.out.println("Please enter meeting description:");
        System.out.print("Meeting Id - ");

        Scanner scanner = new Scanner(System.in);
        MeetingManyManyA meeting = meetingManyManyADao.get(scanner.nextInt());
        if (meeting == null) {
            System.out.println("Meeting doesn't exist. Please enter a new Meeting SUBJECT - ");
            scanner = new Scanner(System.in);
            meeting = createNewMeeting(scanner.nextLine());
        }

        System.out.println("Please enter employee description:");
        System.out.print("Name - ");
        /*if(person == null) {*/employee = new EmployeeManyManyA();/*}*/
        scanner = new Scanner(System.in);
        employee.setName(scanner.nextLine());
        System.out.print("Surname - ");
        employee.setSurname(scanner.nextLine());

        employee.getMeetings().add(meeting);
        meeting.getEmployees().add(employee);

        employeeManyManyADao.saveOrUpdate(employee);

        return employee;
    }

    public static EmployeeManyManyA getEmployeeManyMany (EmployeeManyManyA employee) throws DaoException4 {
        System.out.println("Get EmployeeManyManyA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeManyManyADao.get(id);
        return employee;
    }

    public static EmployeeManyManyA updateEmployeeManyMany (EmployeeManyManyA employee) throws DaoException4 {
        System.out.println("Update EmployeeManyManyA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeManyManyADao.get(id);

        System.out.print("Add new MEETING by ID - ");
        scanner = new Scanner(System.in);
        MeetingManyManyA meeting = meetingManyManyADao.get(scanner.nextInt());
        if (meeting == null) {
            System.out.println("Meeting doesn't exist. Please enter a new Meeting SUBJECT - ");
            scanner = new Scanner(System.in);
            meeting = createNewMeeting(scanner.nextLine());
        }
        employee.getMeetings().add(meeting);
        meeting.getEmployees().add(employee);

        employeeManyManyADao.saveOrUpdate(employee);
        return employee;
    }

    public static void deleteEmployeeManyMany (EmployeeManyManyA employee) throws DaoException4 {
        System.out.println("Delete EmployeeManyManyA by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeManyManyADao.get(id);
        if (employee != null) {
            employeeManyManyADao.delete(employee);
        } else {
            System.out.println("No such EmployeeManyManyA in DataBase!");
        }
    }
}
