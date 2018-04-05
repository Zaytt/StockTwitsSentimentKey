package stocktwits.exception;

// also put this in exception package
public class APIUnavailableException extends Exception {

    public String toString(){
        return "This API is currently unavailable - please try again later.";
    }

}