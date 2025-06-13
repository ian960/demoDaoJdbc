package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("Test 1: seller findById");
        System.out.print("Id: ");
        int findId = sc.nextInt();
        Seller seller = sellerDao.findById(findId);
        System.out.println(seller);

        System.out.println("\nTest 2: seller findByDepartment");
        System.out.print("Department ID: ");
        int depID = sc.nextInt();
        Department department = new Department(depID, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        printSellers(list);

        System.out.println("\nTest 3: seller findAll");
        list = sellerDao.findAll();
        printSellers(list);

        System.out.println("\nTest 4: seller insert");
        sc.nextLine(); // limpa o buffer antes do nextLine
        System.out.print("Seller name: ");
        String name = sc.nextLine();
        System.out.print("Seller email: ");
        String email = sc.nextLine();
        System.out.print("Salary: ");
        double sal = sc.nextDouble();
        System.out.print("Department id: ");
        int id2 = sc.nextInt();
        Department department1 = new Department(id2, null);
        Seller newSeller = new Seller(null, name, email, new Date(), sal, department1);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New Id = " + newSeller.getId());

        System.out.println("\nAll sellers after insert:");
        list = sellerDao.findAll();
        printSellers(list);

        System.out.println("\nTest 5: seller update");
        System.out.print("Seller id: ");
        int updateId = sc.nextInt();
        seller = sellerDao.findById(updateId);
        sc.nextLine(); // limpa o buffer
        System.out.print("New name: ");
        String updateName = sc.nextLine();
        seller.setName(updateName);
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\nAll sellers after update:");
        list = sellerDao.findAll();
        printSellers(list);

        System.out.println("\nTest 6: seller delete");
        System.out.print("Seller id: ");
        int deleteId = sc.nextInt();
        sellerDao.deleteById(deleteId);
        System.out.println("Delete completed");

        System.out.println("\nAll sellers after delete:");
        list = sellerDao.findAll();
        printSellers(list);

        sc.close();
    }

    private static void printSellers(List<Seller> list) {
        for (Seller obj : list) {
            System.out.println(obj);
        }
    }
}
