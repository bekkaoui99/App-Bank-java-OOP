package ma.bank.entities;



import java.util.Random;
import java.util.UUID;

public abstract class BankAcount {

    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private String acountCode;

    private AcountState state;

    private double balance;

Random r = new Random();
    public BankAcount(){
        this.id = UUID.randomUUID().toString();
        this.acountCode = Integer.toString(r.nextInt(900000000));
        this.state = AcountState.CREATED;

    }

    public BankAcount(String firstName , String lastName , String userName , String email , String password , double balance){
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.balance = balance;

    }


    public void setFirstName(String firstName){
        this.firstName  = firstName;
    }

    public String getFirstName(){
        return  this.firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getLastName(){
        return this.lastName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return this.userName;
    }


    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setBalance(double balance){
        this.balance  = balance;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getAcountCode(){
        return  this.acountCode;
    }



    public abstract String getType();

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", acountCode='" + acountCode + '\'' +
                ", state=" + state +
                ", balance=" + balance ;
    }
}
