package Model;

/**
 * Created by joshuakelley on 9/28/16.
 */
public class Password {
    private final String encryptedPassword;
    private final int encryptionCipher;

    /**
     * creates and sets cipher, also calls encryptPassword so original password is never held
     * by object
     * @param unencryptedPassword original password String
     */
    public Password(String unencryptedPassword){
        encryptionCipher=(int)(((Math.random()*100)+1)%93)+1;
        this.encryptedPassword=encryptPassword(unencryptedPassword);
    }

    /**
     * builds an encrypted string using the "cipher" integer specified during creation
     * @param passwordBeforeEncryption original password String
     * @return
     */
    public String encryptPassword(String passwordBeforeEncryption){
        StringBuilder encryptedPassword=new StringBuilder();
        for (int i=0;i<passwordBeforeEncryption.length();i++){
            char shiftLetter = passwordBeforeEncryption.charAt(i);
            int shiftHolder;
            if(shiftLetter+encryptionCipher>126){
                shiftHolder=(((shiftLetter+encryptionCipher)%126)+33);
                //shiftLetter=Character.forDigit((Character.digit(shiftLetter,10)+cipher+33)-126,10);
            }else{
                shiftHolder=(shiftLetter+encryptionCipher);
                //shiftLetter=Character.forDigit(Character.digit(shiftLetter,10)+cipher,10);
            }
            shiftLetter=(char)shiftHolder;
            encryptedPassword.append(shiftLetter);
            //char newCharacter=shift+cipher;

        }
        return encryptedPassword.toString();
    }

    /**
     * reverses encryptPassword process
     * @param encryptedPassword encrypted password to be decrypted
     * @return decrypted password
     */
    public String decryptPassword(String encryptedPassword){
        int shifter;
        StringBuilder decryptedPassword=new StringBuilder();
        for(int i=0;i<encryptedPassword.length();i++){
            shifter=encryptedPassword.charAt(i)-encryptionCipher;
            if(shifter<33){
                shifter+=93;
            }
            char shiftLetter=(char)shifter;
            decryptedPassword.append(shiftLetter);
        }
        return decryptedPassword.toString();
    }

    /**
     * makes encrypted password viewable without changing the object
     * @return
     */
    @Override
    public String toString(){
        return decryptPassword(encryptedPassword);
    }

}
