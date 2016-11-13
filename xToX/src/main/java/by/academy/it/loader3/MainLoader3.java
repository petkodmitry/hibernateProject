package by.academy.it.loader3;

import by.academy.it.db3.*;
import by.academy.it.pojos3.*;
import org.apache.log4j.Logger;

import java.util.Scanner;
import java.util.Set;

public class MainLoader3 {
    private static Logger log = Logger.getLogger(MainLoader3.class);
    private static EmployeeOneOneDao employeeOneOneDao = EmployeeOneOneDao.getInstance();
    private static DepartmentOneOneDao departmentOneOneDao = DepartmentOneOneDao.getInstance();
    private static EmployeeOneManyDao employeeOneManyDao = EmployeeOneManyDao.getInstance();
    private static DepartmentOneManyDao departmentOneManyDao = DepartmentOneManyDao.getInstance();
    private static EmployeeManyManyDao employeeManyManyDao = EmployeeManyManyDao.getInstance();
    private static MeetingManyManyDao meetingManyManyDao = MeetingManyManyDao.getInstance();

    public static void main(String args[]) throws DaoException {
        EmployeeOneOne employeeOneOne = null;
        EmployeeOneMany employeeOneMany = null;
        EmployeeManyMany employeeManyMany = null;

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0); break;

                case 1:
                    employeeOneOne = createEmployeeOne(employeeOneOne);
                    System.out.println(employeeOneOne);
                    break;
                case 2:
                    employeeOneOne = getEmployeeOne(employeeOneOne);
                    System.out.println(employeeOneOne);
                    break;
                case 3:
                    employeeOneOne = updateEmployeeOne(employeeOneOne);
                    System.out.println(employeeOneOne);
                    break;
                case 4:
                    deleteEmployeeOne(employeeOneOne);
                    break;

                case 11:
                    employeeOneMany = createEmployeeMany(employeeOneMany);
                    System.out.println(employeeOneMany);
                    break;
                case 12:
                    employeeOneMany = getEmployeeMany(employeeOneMany);
                    System.out.println(employeeOneMany);
                    break;
                case 13:
                    employeeOneMany = updateEmployeeMany(employeeOneMany);
                    System.out.println(employeeOneMany);
                    break;
                case 14:
                    deleteEmployeeMany(employeeOneMany);
                    break;

                case 21:
                    employeeManyMany = createEmployeeManyMany(employeeManyMany);
                    System.out.println(employeeManyMany);
                    break;
                case 22:
                    employeeManyMany = getEmployeeManyMany(employeeManyMany);
                    System.out.println(employeeManyMany);
                    break;
                case 23:
                    employeeManyMany = updateEmployeeManyMany(employeeManyMany);
                    System.out.println(employeeManyMany);
                    break;
                case 24:
                    deleteEmployeeManyMany(employeeManyMany);
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
        System.out.println("        1. Create EmployeeOneOne+DepartmentOneOne");
        System.out.println("        2. Read(Get) EmployeeOneOne+DepartmentOneOne");
        System.out.println("        3. Update EmployeeOneOne+DepartmentOneOne");
        System.out.println("        4. Delete EmployeeOneOne+DepartmentOneOne");
        System.out.println();
        System.out.println("        11. Create EmployeeOneMany+DepartmentOneMany");
        System.out.println("        12. Read(Get) EmployeeOneMany+DepartmentOneMany");
        System.out.println("        13. Update EmployeeOneMany+DepartmentOneMany");
        System.out.println("        14. Delete EmployeeOneMany+DepartmentOneMany");
        System.out.println();
        System.out.println("        21. Create EmployeeManyMany+MeetingManyMany");
        System.out.println("        22. Read(Get) EmployeeManyMany+MeetingManyMany");
        System.out.println("        23. Update EmployeeManyMany+MeetingManyMany");
        System.out.println("        24. Delete EmployeeManyMany+MeetingManyMany");
    }

    public static EmployeeOneOne createEmployeeOne(EmployeeOneOne employee) throws DaoException{
        System.out.println("Creating EmployeeOneOne:");
        System.out.print("Name - ");
        /*if(person == null) {*/employee = new EmployeeOneOne();/*}*/
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        employee.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        employee.setSurname(parameter);

        DepartmentOneOne details = new DepartmentOneOne();
        System.out.print("Street - ");
        details.setStreet(scanner.nextLine());
        System.out.print("City - ");
        details.setCity(scanner.nextLine());
        System.out.print("State - ");
        details.setState(scanner.nextLine());

        details.setEmployee(employee);
        employee.setDetails(details);

        employeeOneOneDao.saveOrUpdate(employee);
        return employee;
    }

    public static EmployeeOneOne getEmployeeOne (EmployeeOneOne employee) throws DaoException{
        System.out.println("Get EmployeeOneOne by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneOneDao.get(id);
        return employee;
    }

    public static EmployeeOneOne updateEmployeeOne (EmployeeOneOne employee) throws DaoException{
        System.out.println("Update EmployeeOneOne by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneOneDao.get(id);

        System.out.print("Set new CITY - ");
        scanner = new Scanner(System.in);
        employee.getDetails().setCity(scanner.nextLine());

        employeeOneOneDao.saveOrUpdate(employee);
        return employee;
    }

    public static void deleteEmployeeOne (EmployeeOneOne employee) throws DaoException{
        System.out.println("Delete EmployeeOneOne by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneOneDao.get(id);
        try {
            employeeOneOneDao.delete(employee);
        } catch (DaoException e) {
            System.out.println("No such EmployeeOneOne in DataBase!");
        }
    }

    public static DepartmentOneMany createNewDepartment(String name) {
        DepartmentOneMany dep = new DepartmentOneMany();
        dep.setDepName(name);
        return dep;
    }

    public static EmployeeOneMany createEmployeeMany(EmployeeOneMany employee) throws DaoException{
        System.out.println("Please enter department description:");
        System.out.print("Department Id - ");

        Scanner scanner = new Scanner(System.in);
        DepartmentOneMany department = departmentOneManyDao.get(scanner.nextInt());
        if (department == null) {
            System.out.println("Department doesn't exist. Please enter a new Department NAME - ");
            scanner = new Scanner(System.in);
            department = createNewDepartment(scanner.nextLine());
        }

        System.out.println("Please enter employee description:");
        System.out.print("Name - ");
        /*if(person == null) {*/employee = new EmployeeOneMany();/*}*/
        scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        employee.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        employee.setSurname(parameter);

        employee.setDepartment(department);
        department.getEmployees().add(employee);

        employeeOneManyDao.saveOrUpdate(employee);

        return employee;
    }

    public static EmployeeOneMany getEmployeeMany (EmployeeOneMany employee) throws DaoException{
        System.out.println("Get EmployeeOneMany by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneManyDao.get(id);
        return employee;
    }

    public static EmployeeOneMany updateEmployeeMany (EmployeeOneMany employee) throws DaoException{
        System.out.println("Update EmployeeOneMany by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneManyDao.get(id);

        System.out.print("Set new NAME - ");
        scanner = new Scanner(System.in);
        employee.setName(scanner.nextLine());

        employeeOneManyDao.saveOrUpdate(employee);
        return employee;
    }

    public static void deleteEmployeeMany (EmployeeOneMany employee) throws DaoException{
        System.out.println("Delete EmployeeOneMany by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeOneManyDao.get(id);
        if (employee != null) {
            Set<EmployeeOneMany> set = employee.getDepartment().getEmployees();
            System.out.println("department.size() = " + set.size());
            set.remove(employee);
            employeeOneManyDao.delete(employee);
            System.out.println("department.size() = " + set.size());
        } else {
            System.out.println("No such EmployeeOneMany in DataBase!");
        }
    }

    public static MeetingManyMany createNewMeeting(String name) {
        MeetingManyMany dep = new MeetingManyMany();
        dep.setSubject(name);
        return dep;
    }

    public static EmployeeManyMany createEmployeeManyMany(EmployeeManyMany employee) throws DaoException{
        System.out.println("Please enter meeting description:");
        System.out.print("Meeting Id - ");

        Scanner scanner = new Scanner(System.in);
        MeetingManyMany meeting = meetingManyManyDao.get(scanner.nextInt());
        if (meeting == null) {
            System.out.println("Meeting doesn't exist. Please enter a new Meeting SUBJECT - ");
            scanner = new Scanner(System.in);
            meeting = createNewMeeting(scanner.nextLine());
        }

        System.out.println("Please enter employee description:");
        System.out.print("Name - ");
        /*if(person == null) {*/employee = new EmployeeManyMany();/*}*/
        scanner = new Scanner(System.in);
        employee.setName(scanner.nextLine());
        System.out.print("Surname - ");
        employee.setSurname(scanner.nextLine());

        employee.getMeetings().add(meeting);
        meeting.getEmployees().add(employee);

        employeeManyManyDao.saveOrUpdate(employee);

        return employee;
    }

    public static EmployeeManyMany getEmployeeManyMany (EmployeeManyMany employee) throws DaoException{
        System.out.println("Get EmployeeManyMany by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeManyManyDao.get(id);
        return employee;
    }

    public static EmployeeManyMany updateEmployeeManyMany (EmployeeManyMany employee) throws DaoException{
        System.out.println("Update EmployeeManyMany by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeManyManyDao.get(id);

        System.out.print("Add new MEETING by ID - ");
        scanner = new Scanner(System.in);
        MeetingManyMany meeting = meetingManyManyDao.get(scanner.nextInt());
        if (meeting == null) {
            System.out.println("Meeting doesn't exist. Please enter a new Meeting SUBJECT - ");
            scanner = new Scanner(System.in);
            meeting = createNewMeeting(scanner.nextLine());
        }
        employee.getMeetings().add(meeting);
        meeting.getEmployees().add(employee);

        employeeManyManyDao.saveOrUpdate(employee);
        return employee;
    }

    public static void deleteEmployeeManyMany (EmployeeManyMany employee) throws DaoException{
        System.out.println("Delete EmployeeManyMany by Id.");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();

        employee = employeeManyManyDao.get(id);
        if (employee != null) {
            employeeManyManyDao.delete(employee);
        } else {
            System.out.println("No such EmployeeManyMany in DataBase!");
        }
    }
}
