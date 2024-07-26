package io;

import dto.BankAccount;
import service.BankService;
import service.BankServiceImpl;

import java.util.List;
import java.util.Scanner;

public class Main {
    static BankService service = new BankServiceImpl();
    public static void main(String[] args) {
        char c;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the operation you want to Perform: ");
            System.out.println("1. Create Bank Account");
            System.out.println("2. Display Bank Account");
            System.out.println("3. Update Bank Account");
            System.out.println("4. Delete Bank Account");
            System.out.println("5. Display by Account Num");
            System.out.println("6. Display by Account Name");
            System.out.println("7. Display City by Name: ");
            System.out.println("8. Display all Bank Accounts using code: ");
            System.out.println("9. GroupBy Bank Account");
            System.out.println("10. exit");
            int operation = sc.nextInt();
            switch (operation) {
                case 1:
                    createRecords();
                    break;
                case 2:
                    showRecords();
                    break;
                case 3:
                    updateRecords();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    byAccNum();
                    break;
                case 6:
                    fetch1();
                    break;
                case 7:
                    fetch2();
                    break;
                case 8:
                    code();
                    break;
                case 9:
                    groupBy();
                    break;
                default:
                    System.out.println("Invalid Operation");
            }
            System.out.println("do you want to continue? (y/n)");
            c = sc.next().charAt(0);
        }while (c=='y'|| c=='Y');
        //showRecords();
        //updateRecords();
        //delete();
        //byAccNum();
        //fetch1();
        //code();
        //fetch2();
        //groupBy();
    }

    private static void groupBy() {
        List<Object[]> bank = service.groupBy();
        for(Object[] ob: bank)
        {
            System.out.println(ob[0]+":"+ob[1]+":"+ob[2]);
        }
    }

    private static void fetch2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name");
        String name = sc.nextLine();
        List<String> pl = service.fetch2(name);
        pl.forEach(System.out::println);
    }

    private static void code() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the code: ");
        int num = sc.nextInt();
        List<BankAccount> pl = service.displayBank(num);
        pl.forEach(System.out::println);
    }

    private static void fetch1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name");
        String name = sc.nextLine();
        List<BankAccount> pl = service.displayAcc(name);
        pl.forEach(System.out::println);
    }

    private static void byAccNum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num");
        int num = sc.nextInt();
        List<BankAccount> pl = service.displayAcc(num);
        pl.forEach(System.out::println);
    }

    private static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Branch num you want to delete: ");
        int no = sc.nextInt();
        BankAccount p = new BankAccount();
        p.setActNumber(no);
        service.deleteDetails(p);
        System.out.println("Record Deleted");
    }

    private static void updateRecords() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the acc no: ");
        int code = sc.nextInt();
        System.out.println("Enter the Customer Name: ");
        String name = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter the city: ");
        String city = sc.nextLine();
        BankAccount bank = new BankAccount();
        bank.setActNumber(code);
        bank.setCustomerName(name);
        bank.setCity(city);
        service.updateDetails(bank);
        System.out.println("Records Updated");
    }

    private static void showRecords() {
        List<BankAccount> bank = service.showDetails();
        bank.forEach(System.out::println);
    }

    private static void createRecords() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Bank accountNo: ");
        int acno = sc.nextInt();
        System.out.println("Enter the Customer Name: ");
        String name = sc.next();
        sc.nextLine();
        System.out.println("Enter the Bank Balance: ");
        double bal = sc.nextDouble();
        System.out.println("Enter the Bank City: ");
        String city = sc.next();
        sc.nextLine();
        System.out.println("Enter the Bank Code: ");
        int code = sc.nextInt();
        BankAccount b = new BankAccount(acno, name, bal, city, code);
        service.createDetails(b);
        System.out.println("Records added Successfully");
    }
}
