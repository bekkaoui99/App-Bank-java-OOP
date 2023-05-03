package ma.bank.service.imp;

import ma.bank.entities.BankAcount;
import ma.bank.entities.CurentAcount;
import ma.bank.entities.SavingAcount;
import ma.bank.exception.BalanceNotSufficient;
import ma.bank.exception.ResourceNoutFoundException;
import ma.bank.service.BankAcountService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BankAcountImp implements BankAcountService {
    Random random = new Random();

    List<BankAcount> bankAcountList = new ArrayList<>();


    @Override
    public BankAcount createAcount(BankAcount bankAcount) {
        bankAcountList.add(bankAcount);
        return bankAcount;
    }



    @Override
    public BankAcount getAcountByUserName(String userName) throws ResourceNoutFoundException{
       return bankAcountList.
                stream()
                .filter(acount -> acount.getUserName().equals(userName))
                .findFirst().orElseThrow(() -> new ResourceNoutFoundException("acount"));

    }

    @Override
    public BankAcount getAcountByAcountCode(String acountCode) throws ResourceNoutFoundException {
        return bankAcountList
                .stream()
                .filter(acount -> acount.getAcountCode().equals(acountCode))
                .findFirst().orElseThrow(()-> new  ResourceNoutFoundException("Acount"));
    }

    @Override
    public void deleteAcountByUserName(String userName) throws ResourceNoutFoundException{
        BankAcount getAcount = bankAcountList
                                .stream()
                                .filter(acount -> acount.getUserName().equals(userName))
                                .findFirst().orElseThrow(() -> new ResourceNoutFoundException("Acount"));

        bankAcountList.remove(getAcount);

    }

    @Override
    public void deleteAcountByAcountCode(String acountCode) throws ResourceNoutFoundException{

        BankAcount getAcount = bankAcountList
                .stream()
                .filter(acount -> acount.getAcountCode().equals(acountCode))
                .findFirst()
                .orElseThrow(() -> new ResourceNoutFoundException("acount"));

        bankAcountList.remove(getAcount);
    }

    @Override
    public BankAcount updateAcount(BankAcount bankAcount) {

        return bankAcountList.set(bankAcountList.indexOf(bankAcount) , bankAcount);
    }

    @Override
    public List<BankAcount> getAllAcount() {
        return bankAcountList;
    }

    @Override
    public List<BankAcount> createRandomAcount(int size) {
        List<BankAcount> allAcount = new ArrayList<>();

        String[] firstNames = {"hamza","khalid","toufik","aziz","ahmad","mehdi"};
        String[] lastNames = {"mekkaoui","belayal","bennani","chafai","amdari","faraje"};


        BankAcount bankAcount ;

        for (int i = 0 ; i < size ; i++){
            String randomFirstName = firstNames[random.nextInt((firstNames.length - 1))];
            String randomLasttName = lastNames[random.nextInt((lastNames.length - 1))];
            String randomEmail = randomFirstName.toUpperCase().charAt(0) + randomFirstName.substring(1)+"@gmail.com";
            bankAcount = (Math.random()>0.5)
                    ? new SavingAcount(randomFirstName,randomLasttName,randomFirstName +"_"+ randomLasttName,randomLasttName + randomEmail,Integer.toString(random.nextInt(90000)),Math.random()*1000000,Math.random()*100)
                    : new CurentAcount(randomFirstName,randomLasttName,randomFirstName +"_"+ randomLasttName,randomLasttName + randomEmail,Integer.toString(random.nextInt(90000)),Math.random()*1000000,Math.random()*100);


            allAcount.add(bankAcount);
            bankAcountList.add(bankAcount);
        }
        return allAcount;
    }

    @Override
    public void debit(String code, double amount) throws ResourceNoutFoundException, BalanceNotSufficient {
        BankAcount getAcount = bankAcountList
                .stream()
                .filter(acount -> acount.getAcountCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new ResourceNoutFoundException("acount"));

        if(amount < getAcount.getBalance()){
            getAcount.setBalance(getAcount.getBalance() - amount);
        }
        else throw new BalanceNotSufficient("Balance Not Sufficient");


    }

    @Override
    public void credit(String code, double amount) throws ResourceNoutFoundException {
        BankAcount getAcount = getAcountByAcountCode(code);
        getAcount.setBalance(getAcount.getBalance() + amount);

    }

    @Override
    public void transfer(String acountSource, String acountDestination, double amount) throws ResourceNoutFoundException, BalanceNotSufficient {
       debit(acountSource , amount);
       credit(acountDestination , amount);


    }

    @Override
    public double getAllBalance() {
        return bankAcountList.
                stream().
                map(bankAcount -> bankAcount.getBalance())
                .reduce(0.0, (a, b) -> a + b);
    }


    @Override
    public boolean auth(String userName, String password) throws ResourceNoutFoundException{
        BankAcount acountByUserName = getAcountByUserName(userName);

        return acountByUserName.getPassword().equals(password);
    }
}
