package ma.bank.entities;

public class SavingAcount extends BankAcount{

    private double interestRate;

    public  SavingAcount(){
        super();
    }



    public SavingAcount(String firstName, String lastName, String userName, String email, String password, double balance, double interestRate) {
        super(firstName, lastName, userName, email, password, balance);
        this.interestRate = interestRate;
    }


    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }


    public double getInterestRate(){
        return this.interestRate;
    }


    @Override
    public String getType() {
        return "SavingAcount";
    }

    @Override
    public String toString() {
        return "SavingAcount : =>" +
               super.toString() + " , interestRate=" + interestRate +
                '}';
    }
}
