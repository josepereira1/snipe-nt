package exceptions;

public class SnipeNotExistsException extends Exception{

    public SnipeNotExistsException(String snipeName) {
        super(String.format("Snipe with name \"%s\" not exists.", snipeName));
    }
}
