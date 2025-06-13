package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Departmentest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("Test 1: FindByID: ");
        System.out.println("ID: ");
        int id = sc.nextInt();
        Department department = departmentDao.findById(id);
        System.out.println(department);

        System.out.println("Test 2: FindAll: ");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }

        System.out.println("Test 3: Insert: ");
        sc.nextLine();
        System.out.println("Department Name: ");
        String name = sc.nextLine();
        Department department1 = new Department(null, name);
        departmentDao.insert(department1);

        System.out.println("Test 4: Update: ");
        System.out.println("Department Id: ");
        id = sc.nextInt();
        department1 = departmentDao.findById(id);
        sc.nextLine();
        System.out.println("New name: ");
        String depName = sc.nextLine();
        department1.setName(depName);
        departmentDao.update(department1);
        System.out.println("Update complete");

        System.out.println("Test 5: Delete: ");
        System.out.println("Department Id: ");
        id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Deleted");




    }
}
