package stocktwits.exception;

public class SymbolNotFoundException extends Exception {
    @Override
    public String toString() {
        return "Symbol not found";
    }
}
