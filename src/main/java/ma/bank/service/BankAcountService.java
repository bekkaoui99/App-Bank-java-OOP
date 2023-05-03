package ma.bank.service;

import ma.bank.entities.BankAcount;
import ma.bank.exception.BalanceNotSufficient;
import ma.bank.exception.ResourceNoutFoundException;

import java.util.List;

public interface BankAcountService {



    BankAcount createAcount(BankAcount bankAcount);


    BankAcount getAcountByUserName(String userName) throws ResourceNoutFoundException;
    BankAcount getAcountByAcountCode(String acountCode) throws ResourceNoutFoundException;

    void deleteAcountByUserName(String userName) throws ResourceNoutFoundException;
    void deleteAcountByAcountCode(String acountCode) throws ResourceNoutFoundException;

    BankAcount updateAcount(BankAcount bankAcount);

    List<BankAcount> getAllAcount();

    List<BankAcount> createRandomAcount(int size);


    void debit(String code ,double amount ) throws ResourceNoutFoundException, BalanceNotSufficient;
    void credit(String code ,double amount ) throws ResourceNoutFoundException;
    void transfer(String AcountSource, String AcountDestination , double amount) throws ResourceNoutFoundException, BalanceNotSufficient;


    double getAllBalance();

    boolean auth(String userName ,String password) throws ResourceNoutFoundException;



}
