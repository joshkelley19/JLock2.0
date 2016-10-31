package Model;

/**
 * Created by joshuakelley on 10/6/16.
 */
public class PasswordManager {
    public Password currentPassword;

    public Password createNewPassword(String unencryptedPassword){
        int cipher = createCipher();
        return new Password(encryptPassword(unencryptedPassword,cipher),cipher);
    }

    public int createCipher(){
        return (int)(((Math.random()*100)+1)%93)+1;
    }

    /**
     * builds an encrypted string using the "cipher" integer specified during creation
     * @param passwordBeforeEncryption original password String
     * @return
     */
    public String encryptPassword(String passwordBeforeEncryption, int encryptionCipher){
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
    public String decryptPassword(String encryptedPassword, int encryptionCipher){
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

    public String getPassword(Password encryptedPassword){
        return decryptPassword(encryptedPassword.toString(),encryptedPassword.encryptionCipher);
    }
}
