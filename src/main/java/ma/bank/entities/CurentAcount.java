package ma.bank.entities;

public class CurentAcount  extends BankAcount{

    private double overDraft;

    public CurentAcount(){
        super();
    }


    public CurentAcount(String firstName, String lastName, String userName, String email, String password, double balance, double overDraft) {
        super(firstName, lastName, userName, email, password, balance);
        this.overDraft = overDraft;
    }


    public void setOverDraft(double overDraft){
        this.overDraft = overDraft;
    }

    public double getOverDraft(){
        return this.overDraft;
    }

    @Override
    public String getType() {
        return "CurentAcount";
    }


    @Override
    public String toString() {

        return "CurentAcount : => " +
               super.toString() +  " , overDraft=" + overDraft +
                '}' ;
    }
}
