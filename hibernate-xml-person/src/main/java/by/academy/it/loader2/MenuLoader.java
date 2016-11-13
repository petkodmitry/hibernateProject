/*
 * Copyright (c) 2012 by VeriFone, Inc.
 * All Rights Reserved.
 *
 * THIS FILE CONTAINS PROPRIETARY AND CONFIDENTIAL INFORMATION
 * AND REMAINS THE UNPUBLISHED PROPERTY OF VERIFONE, INC.
 *
 * Use, disclosure, or reproduction is prohibited
 * without prior written approval from VeriFone, Inc.
 */
package by.academy.it.loader2;

import by.academy.it.db2.CarDao;
import by.academy.it.db2.PersonDao;
import by.academy.it.db2.exceptions.DaoException;
import by.academy.it.pojos2.Car;
import by.academy.it.pojos2.Person;
import org.apache.log4j.Logger;
import org.hibernate.ObjectNotFoundException;

import java.util.Scanner;

/**
 * User: yslabko
 * Date: 14.04.14
 * Time: 12:28
 */
public class MenuLoader {
    private static Logger log = Logger.getLogger(MenuLoader.class);
    public static Boolean needMenu = true;
    private static PersonDao personDao = null;
    private static CarDao carDao = null;

    public static void menu() throws DaoException {
        Person person = null;
        while (needMenu) {
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
                    getPersonDao().saveOrUpdate(person);
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
                case 10:
                    insertCar();
                    break;
                case 11:
                    changeCarYear();
                    break;
                default:
                    needMenu = true;
                    break;
            }
            needMenu = true;
        }

    }

    private static void printMenu() {
        System.out.println(" Options:");
        System.out.println("        0. Exit");
        System.out.println("        1. Delete Person");
        System.out.println("        2. Get Person");
        System.out.println("        3. Save or Update Person");
        System.out.println("        4. Load Person");
        System.out.println("        5. Flush Person");
        System.out.println("        6. Refresh Person");
        System.out.println("        10. Insert a car");
        System.out.println("        11. Change car year");
    }

    public static Person createPerson(Person person) {
        System.out.println("Please enter person description:");
        System.out.print("Name - ");

        if(person == null) {person = new Person();}
        Scanner scanner = new Scanner(System.in);
        String parameter = scanner.nextLine();
        person.setName(parameter);
        System.out.print("Surname - ");
        parameter = scanner.nextLine();
        person.setSurname(parameter);
        System.out.print("Age - ");
        person.setAge(scanner.nextInt());
//        person.setPersonAddress(new Address());
//        person.getPersonAddress().setCity("Minsk");
//        person.getPersonAddress().setStreet("Gaya");
        return person;
    }

    public static void deletePerson() {
        System.out.println("Delete by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        try {
            person = getPersonDao().get(id);
            getPersonDao().delete(person);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable delete person:", e);
        }
    }

    public static Person findPerson() {
        System.out.println("Get by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        try {
            person = getPersonDao().get(id);
            System.out.print(person);
        } catch (DaoException e) {
            log.error(e, e);
        } catch (NullPointerException e) {
            log.error("Unable find person:", e);
        }
        return person;
    }

    public static Person loadPerson() {
        System.out.println("Loag by Id. Please enter person id:");
        System.out.print("Id - ");

        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        try {
            person = getPersonDao().load(id);
            System.out.print(person);
        } catch (DaoException e) {
            log.error(e);
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (/*NullPointerException |*/ ObjectNotFoundException e) {
            log.error("Unable load person:" + e);
        }
        return person;
    }

    public static void flushSession() {
        System.out.println("Please enter person id:");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
        Person person = null;
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            getPersonDao().flush(id, name);
        } catch (DaoException e) {
            log.error("Unable run flush example");
        }
    }

    public static void refreshSession() {
        System.out.println("Please enter person id (for refreshing):");
        System.out.print("Id - ");
        Scanner scanner = new Scanner(System.in);
//        Person person = null;
        Integer id = scanner.nextInt();
        System.out.println("Please enter new Name:");
        System.out.print("New Name - ");
        scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        try {
            getPersonDao().refresh(id, name);
        } catch (DaoException e) {
            log.error("Unable run refresh example");
        }
    }

    public static void insertCar() {
        Car car = new Car();
        System.out.print("Please enter BRAND of a car");
        Scanner scanner = new Scanner(System.in);
        String brand = scanner.nextLine();
        car.setBrand(brand);
        System.out.print("Please enter MODEL of a car");
        scanner = new Scanner(System.in);
        String model = scanner.nextLine();
        car.setModel(model);
        System.out.print("Please enter YEAR of a car");
        scanner = new Scanner(System.in);
        Integer year = scanner.nextInt();
        car.setYear(year);
        try {
            getCarDao().saveOrUpdate(car);
        } catch (DaoException e) {
            log.error("Unable run insertCar example");
        }
    }

    public static void changeCarYear() {
        try {
            Car t = getCarDao().load(1);
            t.setModel("newModel");
            t.setYear(2010);
            getCarDao().saveOrUpdate(t);
            System.out.println(t);
        } catch (DaoException e) {
            log.error("Unable run changeCar example");
        }
    }

    public static PersonDao getPersonDao() {
        if (personDao == null) {
            personDao = new PersonDao();
        }

        return personDao;
    }

    public static CarDao getCarDao() {
        if (carDao == null) {
            carDao = new CarDao();
        }
        return carDao;
    }
}
