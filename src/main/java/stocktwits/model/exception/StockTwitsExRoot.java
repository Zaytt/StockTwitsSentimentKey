package stocktwits.model.exception;

import stocktwits.model.Response;

public class StockTwitsExRoot {

    private Response response;
    private String[] errors;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public String[] getErrors() {
        return errors;
    }

    public void setErrors(String[] errors) {
        this.errors = errors;
    }
}
