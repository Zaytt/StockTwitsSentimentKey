package stocktwits.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import stocktwits.model.exception.StockTwitsExRoot;

@ControllerAdvice
public class ControllerAdviceClass {


    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(APIUnavailableException.class)
    public @ResponseBody CustomException handle404() {
        CustomException error = new CustomException();
        error.setReason("Service Unavailable");
        error.setMessage("Apologies, it appears the API is currently offline. We are not able" +
                " to process your request. Please try again later.");
        error.setStatus(503);
        return error;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(WrongAPIKeyException.class)
    public @ResponseBody CustomException wrongAPIKey() {
        CustomException error = new CustomException();
        error.setReason("Forbidden Access");
        error.setMessage("Your API is invalid or has expired. Try again with a valid API key.");
        error.setStatus(403);
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(SymbolNotFoundException.class)
    public @ResponseBody CustomException symbolNotFound() {
        CustomException error = new CustomException();
        error.setReason("Symbol not found");
        error.setMessage("Unable to find the requested symbol.");
        error.setStatus(404);
        return error;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(RestClientException.class)
    public @ResponseBody CustomException restClientException() {
        CustomException error = new CustomException();
        error.setReason("Unexpected Error");
        error.setMessage("Something went wrong, please try again later.");
        error.setStatus(404);
        return error;
    }




}