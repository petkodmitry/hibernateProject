package by.academy.it.loader2;

import by.academy.it.db2.*;
import by.academy.it.pojos2.*;
import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;

import java.util.Scanner;

public class MainLoader {
    private static Logger log = Logger.getLogger(MainLoader.class);
    private static PersonComponentDao personComponentDao = PersonComponentDao.getInstance();
    private static PersonSubclassDao personSubclassDao = PersonSubclassDao.getInstance();

    private static PersonJoinedDao personJoinedDao = PersonJoinedDao.getInstance();
    private static EmployeeJoinedDao employeeJoinedDao = EmployeeJoinedDao.getInstance();
    private static StudentJoinedDao studentJoinedDao = StudentJoinedDao.getInstance();

    private static PersonUnionDao personUnionDao = PersonUnionDao.getInstance();

    public static void main(String args[]) throws DaoException {
        PersonComponent person = null;

        PersonSubclass personSubclass = null;
        EmployeeSubclass employeeSubclass = null;
        StudentSubclass studentSubclass = null;

        PersonJoined personJoined = null;
        EmployeeJoined employeeJoined = null;
        StudentJoined studentJoined = null;

        PersonUnion personUnion = null;
        EmployeeUnion employeeUnion = null;
        StudentUnion studentUnion = null;

        while (true) {
            printMenu();
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    System.exit(0); break;
                case 1:
                    deletePerson();
                    break;
                case 2:
                    person = findPerson();
                    break;
                case 3:
                    person = createPerson(person);
                    personComponentDao.saveOrUpdate(person);
                    break;
                case 4:
                    person = loadPerson();
                    break;
                case 5:
                    flushSession();
                    break;
                case 6:
                    refreshSession();
                    break;
                case 13:
                    personSubclass = createPersonSubclass(personSubclass);
                    personSubclassDao.saveOrUpdate(personSubclass);
                    break;
                case 14:
                    employeeSubclass = createEmployeeSubclass(employeeSubclass);
                    personSubclassDao.saveOrUpdate(employeeSubclass);
                    break;
                case 15:
                    studentSubclass = createStudentSubclass(studentSubclass);
                    personSubclassDao.saveOrUpdate(studentSubclass);
                    break;
                case 23:
                    personJoined = createPersonJoined(personJoined);
                    personJoinedDao.saveOrUpdate(personJoined);
                    break;
                case 24:
                    employeeJoined = createEmployeeJoined(employeeJoined);
                    employeeJoinedDao.saveOrUpdate(employeeJoined);
                    break;
                case 25:
                    studentJoined = createStudentJoined(studentJoined);
                    studentJoinedDao.saveOrUpdate(studentJoined);
                    break;
                case 26:
                    employeeJoined = getEmployeeJoined();
                    break;
                case 27:
                    studentJoined = getStudentJoined();
                    break;
                case 28:
                    employeeJoined = deleteEmployeeJoined();
                    break;
                case 29:
                    studentJoined = deleteStudentJoined();
                    break;
                case 33:
                    personUnion = createPersonUnion(personUnion);
                    personUnionDao.saveOrUpdate(personUnion);
                    break;
                case 34:
                    employeeUnion= createEmployeeUnion(employeeUnion);
                    personUnionDao.saveOrUpdate(employeeUnion);
                    break;
                case 35:
                    studentUnion = createStudentUnion(studentUnion);
                    personUnionDao.saveOrUpdate(studentUnion);
                    break;
                default:
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println(" Options:");
        System.out.println("        0. Exit");
        System.out.println("        1. Delete PersonComponent");
        System.out.println("        2. Get PersonComponent");
        System.out.println("        3. Save or Update PersonComponent");
        System.out.println("        4. Load PersonComponent");
        System.out.println("        5. Flush PersonComponent");
        System.out.println("        6. Refresh PersonComponent");
        System.out.println("        13. Save or Update PersonSubclass");
        System.out.println("        14. Save or Update EmployeeSubclass");
        System.out.println("        15. Save or Update StudentSubclass");
        System.out.println("        23. Save or Update PersonJoined");
        System.out.println("        24. Save or Update EmployeeJoined");
        System.out.println("        25. Save or Update StudentJoined");
        System.out.println("        26. Get EmployeeJoined");
        System.out.println("        27. Get StudentJoined");
        System.out.println("        28. Delete EmployeeJoined");
        System.out.println("        29. Delete StudentJoined");
        System.out.println("        33. Save or Update PersonUnion");
        System.out.println("        34. Save or Update EmployeeUnion");
        System.out.println("        35. Save or Update StudentUnion");
    }

    public static PersonComponent createPerson(PersonComponent person) {
        System.out.println("Please enter person description:");
        System.out.print("Name - ");

        /*if(person == null) {*/person = new PersonComponent();/*}*/
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        person.setAddress(new AddressComponent());
        person.getAddress().setCity("Minsk");
        person.getAddress().setStreet("Kosmonavtov");
        person.getAddress().setPostalCode("220026");
        return person;
    }

    public static PersonSubclass createPersonSubclass(PersonSubclass person) {
        System.out.println("Please enter personSubclass description:");
        System.out.print("Name - ");
        person = new PersonSubclass();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        return person;
    }

    public static EmployeeSubclass createEmployeeSubclass(EmployeeSubclass person) {
        System.out.println("Please enter EmployeeSubclass description:");
        System.out.print("Name - ");
        person = new EmployeeSubclass();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Company - ");
        parameter = scanner.nextLine();
        person.setCompany(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        System.out.print("Salary - ");
        person.setSalary(scanner.nextDouble());
        return person;
    }

    public static StudentSubclass createStudentSubclass(StudentSubclass person) {
        System.out.println("Please enter StudentSubclass description:");
        System.out.print("Name - ");
        person = new StudentSubclass();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Faculty - ");
        parameter = scanner.nextLine();
        person.setFaculty(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        System.out.print("Mark - ");
        person.setMark(scanner.nextDouble());
        return person;
    }

    public static PersonJoined createPersonJoined(PersonJoined person) {
        System.out.println("Please enter personJoined description:");
        System.out.print("Name - ");
        person = new PersonJoined();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        return person;
    }

    public static EmployeeJoined createEmployeeJoined(EmployeeJoined person) {
        System.out.println("Please enter EmployeeJoined description:");
        System.out.print("Name - ");
        person = new EmployeeJoined();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Company - ");
        parameter = scanner.nextLine();
        person.setCompany(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        System.out.print("Salary - ");
        person.setSalary(scanner.nextDouble());
        return person;
    }

    public static StudentJoined createStudentJoined(StudentJoined person) {
        System.out.println("Please enter StudentJoined description:");
        System.out.print("Name - ");
        person = new StudentJoined();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Faculty - ");
        parameter = scanner.nextLine();
        person.setFaculty(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        System.out.print("Mark - ");
        person.setMark(scanner.nextDouble());
        return person;
    }

    public static EmployeeJoined getEmployeeJoined() {
        System.out.println("Get EmployeeJoined by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        EmployeeJoined person = null;
        Integer id = scanner.nextInt();
        try {
            person = employeeJoinedDao.get(id);
            System.out.print(person);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find EmployeeJoined:" + e);
        }
        return person;
    }

    public static StudentJoined getStudentJoined() {
        System.out.println("Get StudentJoined by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        StudentJoined person = null;
        Integer id = scanner.nextInt();
        try {
            person = studentJoinedDao.get(id);
            System.out.print(person);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find StudentJoined:" + e);
        }
        return person;
    }

    public static EmployeeJoined deleteEmployeeJoined() {
        System.out.println("Deleteing EmployeeJoined by Id.");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        EmployeeJoined person = null;
        Integer id = scanner.nextInt();
        try {
            person = employeeJoinedDao.get(id);
            System.out.print(person);
            if (person != null) {
                employeeJoinedDao.delete(person);
            }
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable delete EmployeeJoined:" + e);
        }
        return person;
    }

    public static StudentJoined deleteStudentJoined() {
        System.out.println("Deleteing StudentJoined by Id.");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        StudentJoined person = null;
        Integer id = scanner.nextInt();
        try {
            person = studentJoinedDao.get(id);
            System.out.print(person);
            if (person != null) {
                studentJoinedDao.delete(person);
            }
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable delete StudentJoined:" + e);
        }
        return person;
    }

    public static PersonUnion createPersonUnion(PersonUnion person) {
        System.out.println("Please enter personJoined description:");
        System.out.print("Name - ");
        person = new PersonUnion();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        return person;
    }

    public static EmployeeUnion createEmployeeUnion(EmployeeUnion person) {
        System.out.println("Please enter EmployeeJoined description:");
        System.out.print("Name - ");
        person = new EmployeeUnion();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Company - ");
        parameter = scanner.nextLine();
        person.setCompany(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        System.out.print("Salary - ");
        person.setSalary(scanner.nextDouble());
        return person;
    }

    public static StudentUnion createStudentUnion(StudentUnion person) {
        System.out.println("Please enter StudentJoined description:");
        System.out.print("Name - ");
        person = new StudentUnion();
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Faculty - ");
        parameter = scanner.nextLine();
        person.setFaculty(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
        System.out.print("Mark - ");
        person.setMark(scanner.nextDouble());
        return person;
    }










    public static void deletePerson() {
        System.out.println("Delete by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        PersonComponent person = null;
        Integer id = scanner.nextInt();
        try {
            person = personComponentDao.get(id);
            personComponentDao.delete(person);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (IllegalArgumentException | NullPointerException e) {
            log.error("Unable delete person:", e);
        }
    }

    public static PersonComponent findPerson() {
        System.out.println("Get by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        PersonComponent person = null;
        Integer id = scanner.nextInt();
        try {
            person = personComponentDao.get(id);
            System.out.print(person);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find person:", e);
        }
        return person;
    }

    public static PersonComponent loadPerson() {
        System.out.println("Loag by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        PersonComponent person = null;
        Integer id = scanner.nextInt();
        try {
            person = personComponentDao.load(id);
            System.out.print(person);
        } catch (DaoException e) {
            log.error(e);
        } catch (ObjectNotFoundException e) {
            log.error("Unable load person:" + e);
        }
        return person;
    }

    public static void flushSession() {
        System.out.println("Please enter person id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            personComponentDao.flush(id, name);
        } catch (DaoException e) {
            log.error("Unable run flush example");
        }
    }

    public static void refreshSession() {
        System.out.println("Please enter person id (for refreshing):");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            personComponentDao.refresh(id, name);
        } catch (DaoException e) {
            log.error("Unable run refresh example");
        }
    }
}
