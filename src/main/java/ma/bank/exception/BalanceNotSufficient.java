package ma.bank.exception;

public class BalanceNotSufficient extends Exception{

    public BalanceNotSufficient(String msg){
        super(msg);
    }
}
