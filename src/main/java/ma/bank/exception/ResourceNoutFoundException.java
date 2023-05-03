package ma.bank.exception;

public class ResourceNoutFoundException extends Exception{

    public ResourceNoutFoundException(String resource){

        super(resource + " not found exception");
    }
}
