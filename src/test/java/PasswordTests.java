import Model.Password;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshuakelley on 9/28/16.
 */
public class PasswordTests {
    Password password0;
    Password password1;

    @Before
    public void initialize(){
        password0=new Password("Jeff");
        password1=new Password("Keith");
    }

    @Test
    public void encryptPasswordTest0(){
        assertFalse(password0.encryptPassword("Password").equals("Password"));
    }

    @Test
    public void encryptPasswordTest1(){
        assertFalse(password0.encryptPassword("RandyWatson").equals("RandyWatson"));
    }

    @Test
    public void decryptPasswordTest0(){
        assertTrue(password0.toString().equals("Jeff"));
    }

    @Test
    public void decryptPasswordTest1(){
        assertTrue(password1.toString().equals("Keith"));
    }
}
