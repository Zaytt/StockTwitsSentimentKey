package stocktwits.exception;

public class WrongAPIKeyException extends Exception {
    public String toString(){
        return "The API Key provided is invalid or has expired.";
    }
}
