package ma.bank;

import ma.bank.entities.BankAcount;
import ma.bank.entities.CurentAcount;
import ma.bank.entities.SavingAcount;
import ma.bank.exception.BalanceNotSufficient;
import ma.bank.exception.ResourceNoutFoundException;
import ma.bank.service.BankAcountService;
import ma.bank.service.imp.BankAcountImp;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        BankAcountService service = new BankAcountImp();


        Scanner scanner = new Scanner(System.in);
      
        int choose = -1 ;
        int chosseAcount = -1;
        do {
            System.out.println("-------------------------------------");
            System.out.println("create acount => 1                  |");
            System.out.println("show informatio  of acount => 2     |");
            System.out.println("delete acount => 3                  |");
            System.out.println("create random acount => 4           |");
            System.out.println("select all acount  => 5             |");
            System.out.println("credit        => 6                  |");
            System.out.println("debit         => 7                  |");
            System.out.println("transfer      => 8                  |");
            System.out.println("show balance  => 9                  |");
            System.out.println("close the app => 0                  |");
            System.out.println("-------------------------------------");
            System.out.print("choose one of this : ");
            choose = scanner.nextInt();

            switch (choose){

                case 1:
                {

                    do {
                        System.out.println("choose one of this : CurentAcoun => 1 ou SavingAcount => 2");
                        chosseAcount = scanner.nextInt();
                        if(chosseAcount == 1){
                           CurentAcount bankAcount = new CurentAcount();
                            System.out.println("your FirstName");
                            String firstName = scanner.next();
                            System.out.println("your LasttName");
                            String lastName = scanner.next();
                            System.out.println("your UserName");
                            String userName = scanner.next();
                            System.out.println("your Email");
                            String email = scanner.next();
                            System.out.println("your password");
                            String password = scanner.next();
                            System.out.println("your balance");
                            double balance = scanner.nextDouble();

                            double overDraft = Math.random()*10;

                            bankAcount.setFirstName(firstName);
                            bankAcount.setLastName(lastName);
                            bankAcount.setUserName(userName);
                            bankAcount.setEmail(email);
                            bankAcount.setPassword(password);
                            bankAcount.setBalance(balance);
                            bankAcount.setOverDraft(overDraft);

                            service.createAcount(bankAcount);
                            System.out.println("************************************");
                            System.out.println("account created successfully");
                            System.out.println("************************************");

                        }
                        else if (chosseAcount == 2){
                            SavingAcount bankAcount = new SavingAcount();
                            System.out.println("your FirstName");
                            String firstName = scanner.next();
                            System.out.println("your LasttName");
                            String lastName = scanner.next();
                            System.out.println("your UserName");
                            String userName = scanner.next();
                            System.out.println("your Email");
                            String email = scanner.next();
                            System.out.println("your password");
                            String password = scanner.next();
                            System.out.println("your balance");
                            double balance = scanner.nextDouble();

                            double interestRate = Math.random()*10;

                            bankAcount.setFirstName(firstName);
                            bankAcount.setLastName(lastName);
                            bankAcount.setUserName(userName);
                            bankAcount.setEmail(email);
                            bankAcount.setPassword(password);
                            bankAcount.setBalance(balance);
                            bankAcount.setInterestRate(interestRate);

                            service.createAcount(bankAcount);
                            System.out.println("************************************");
                            System.out.println("account created successfully");
                            System.out.println("************************************");

                        }

                    }while (chosseAcount != 1 && chosseAcount != 2);

                }
                break;

                case 2:
                {

                    do {
                        System.out.println("select acount by USER_NAME or by ACOUNT_CODE");
                        System.out.println("USER_NAME => 1  |  ACOUNT_CODE => 2");
                        System.out.print("choose one of this : ");
                        choose = scanner.nextInt();

                        try {
                            if(choose == 1){
                                System.out.print("write your UserName : ");
                                String getByUserName = scanner.next();
                                BankAcount acountByUserName = service.getAcountByUserName(getByUserName);

                                System.out.println("===========================================");
                                System.out.println(acountByUserName);
                                System.out.println("===========================================");
                            }
                            else if(choose == 2) {
                                System.out.print("write your AcountCode : ");
                                String getByCode = scanner.next();
                                BankAcount acountByAcountCode = service.getAcountByAcountCode(getByCode);

                                System.out.println("===========================================");
                                System.out.println(acountByAcountCode);
                                System.out.println("===========================================");
                            }



                        } catch (ResourceNoutFoundException e) {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println(e.getMessage());
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            break;
                        }

                    }while (choose != 1 && choose != 2);


                }
                break;

                case 3:
                {
                    do {
                        System.out.println("select acount by USER_NAME or by ACOUNT_CODE");
                        System.out.println("USER_NAME => 1  |  ACOUNT_CODE => 2");
                        System.out.print("choose one of this : ");
                        choose = scanner.nextInt();

                        try {
                            if(choose == 1){
                                System.out.print("write your UserName : ");
                                String getByUserName = scanner.next();
                                service.deleteAcountByUserName(getByUserName);

                                System.out.println("************************************");
                                System.out.println("account deleted successfully");
                                System.out.println("************************************");
                            }
                            else if(choose == 2) {
                                System.out.print("write your AcountCode : ");
                                String getByCode = scanner.next();
                                service.deleteAcountByAcountCode(getByCode);

                                System.out.println("************************************");
                                System.out.println("account deleted successfully");
                                System.out.println("************************************");
                            }



                        } catch (ResourceNoutFoundException e) {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println(e.getMessage());
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            break;
                        }

                    }while (choose != 1 && choose != 2);
                }
                break;

                case 4 :
                {

                    System.out.print("how many acount do you want to create : ");
                    int size = scanner.nextInt();
                    List<BankAcount> bankAcountList = service.createRandomAcount(size);
                    System.out.println("______________________________________________________________");
                    bankAcountList.forEach(acc ->{
                        System.out.println("______________________________________________________________");
                        System.out.println();
                        System.out.println(acc.toString());
                        System.out.println();
                        System.out.println("______________________________________________________________");
                            }

                    );
                    System.out.println("______________________________________________________________");


                }
                break;

                case 5:
                {
                    service.getAllAcount().forEach(acc -> {
                        System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
                        System.out.println();
                        System.out.println(acc.toString());
                        System.out.println();
                        System.out.println("'''''''''''''''''''''''''''''''''''''''''''''''''''''''''");
                    });

                }
                break;

                case 6 :
                {


                        System.out.print("your AcountCode :");
                        String acountCode = scanner.next();
                        System.out.print("How much do you want to add to your account :");
                        double amount = scanner.nextDouble();
                        try {
                            BankAcount acountByAcountCode = service.getAcountByAcountCode(acountCode);
                            double before = acountByAcountCode.getBalance();
                            service.credit(acountCode , amount);
                            double after = acountByAcountCode.getBalance();
                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                            System.out.println("$$$$$$$$$$$$$$$$  successfully  $$$$$$$$$$$$$$$$");
                            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                            System.out.println("sold before is : $ "  + before);
                            System.out.println("sold after  is : $ " + after);




                        } catch (ResourceNoutFoundException e) {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println(e.getMessage());
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        }




                }
                break;

                case 7 :
                {

                     try {
                         System.out.print("your AcountCode :");
                         String acountCode = scanner.next();
                         System.out.print("How much :");
                         double amount = scanner.nextDouble();
                         BankAcount acountByAcountCode = service.getAcountByAcountCode(acountCode);
                         double before =acountByAcountCode.getBalance();
                         service.debit(acountCode,amount);
                         double after =acountByAcountCode.getBalance();
                         System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                         System.out.println("$$$$$$$$$$$$$$$$  successfully  $$$$$$$$$$$$$$$$");
                         System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                         System.out.println("sold before is : $ "  + before);
                         System.out.println("sold after  is : $ " + after);
                     }
                     catch (ResourceNoutFoundException | BalanceNotSufficient e)
                     {
                         System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                         System.out.println(e.getMessage());
                         System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                     }
                }
                break;

                case 8:
                {

                    try {
                        System.out.print("your acount code :");
                        String code_s = scanner.next();

                        System.out.print("destination account code :");
                        String code_d = scanner.next();

                        System.out.print("how much :");
                        double amont = scanner.nextDouble();

                        double balance_source_before = service.getAcountByAcountCode(code_s).getBalance();
                        double balance_destination_before = service.getAcountByAcountCode(code_d).getBalance();

                        service.transfer(code_s , code_d , amont);

                        double balance_source_after = service.getAcountByAcountCode(code_s).getBalance();
                        double balance_destination_after = service.getAcountByAcountCode(code_d).getBalance();
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println("$$$$$$$$$$$$$$$$  successfully  $$$$$$$$$$$$$$$$");
                        System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                        System.out.println("source balance => before : " + balance_source_before  + " | after :" + balance_source_after);
                        System.out.println("destination balance  => before : " + balance_destination_before  + " | after :" + balance_destination_after);



                    } catch (Exception e) {
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                        System.out.println(e.getMessage());
                        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    }
                }
                break;

                case 9 :
                {
                    do {
                        System.out.println("select acount by USER_NAME or by ACOUNT_CODE");
                        System.out.println("USER_NAME => 1  |  ACOUNT_CODE => 2");
                        System.out.print("choose one of this : ");
                        choose = scanner.nextInt();

                        try {
                            if(choose == 1){
                                System.out.print("write your UserName : ");
                                String getByUserName = scanner.next();
                                BankAcount acountByUserName = service.getAcountByUserName(getByUserName);

                                System.out.println("===========================================");
                                System.out.println("your balance is : " + acountByUserName.getBalance());
                                System.out.println("===========================================");
                            }
                            else if(choose == 2) {
                                System.out.print("write your AcountCode : ");
                                String getByCode = scanner.next();
                                BankAcount acountByAcountCode = service.getAcountByAcountCode(getByCode);

                                System.out.println("===========================================");
                                System.out.println("your balance is : " + acountByAcountCode.getBalance());
                                System.out.println("===========================================");
                            }



                        } catch (ResourceNoutFoundException e) {
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            System.out.println(e.getMessage());
                            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                            break;
                        }

                    }while (choose != 1 && choose != 2);

                }
                 break;
            }


        }while (choose != 0);




    }
}
