package Model;

/**
 * Created by joshuakelley on 9/28/16.
 */
public class Password {
    private final String encryptedPassword;
    protected final int encryptionCipher;

    /**
     * sets cipher, also calls encryptPassword so original password is never held
     * by object
     * @param encryptedPassword original password String
     */
    public Password(String encryptedPassword, int encryptionCipher){
        this.encryptedPassword=encryptedPassword;
        this.encryptionCipher=encryptionCipher;
    }

    /**
     * makes encrypted password viewable without changing the object
     * @return
     */
    @Override
    public String toString(){
        return encryptedPassword;
    }

}
