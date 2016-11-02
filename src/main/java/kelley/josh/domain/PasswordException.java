package kelley.josh.domain;

/**
 * Created by joshuakelley on 11/1/16.
 */
public class PasswordException extends RuntimeException {
    PasswordException(String s){
        super(s);
    }

    PasswordException(){

    }
}
