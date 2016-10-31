import Model.Password;
import Model.PasswordManager;
import org.assertj.core.api.Condition;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshuakelley on 9/28/16.
 */
public class PasswordManagerTests {
    Password password0;
    PasswordManager passwordManager0;

    @Before
    public void initialize(){
        passwordManager0 = new PasswordManager();
        password0= passwordManager0.createNewPassword("Jeff");
    }

    @Test
    public void cipherTest(){
        int actual=passwordManager0.createCipher();
        assertTrue(actual <=93 && actual >= 1);
    }

    @Test
    public void encryptPasswordTest0(){
        assertTrue(passwordManager0.encryptPassword("Password",1).equals("Qbttxpse"));
    }

    @Test
    public void decryptPasswordTest0(){
        assertTrue(passwordManager0.getPassword(password0).equals("Jeff"));
    }
}
