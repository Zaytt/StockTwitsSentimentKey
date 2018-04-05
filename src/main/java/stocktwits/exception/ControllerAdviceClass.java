package stocktwits.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ControllerAdviceClass {


    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(APIUnavailableException.class)
    public @ResponseBody CustomException handle404() {
        CustomException error = new CustomException();
        error.setMessage("Apologies, it appears the API is currently offline. We are not able" +
                " to process your request. Please try again later.");
        error.setStatus(503);
        return error;
    }

}