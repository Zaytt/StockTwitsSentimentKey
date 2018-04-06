package stocktwits.exception;

public class APIUnavailableException extends Exception {

    public String toString(){
        return "This API is currently unavailable - please try again later.";
    }
}