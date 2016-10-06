import Model.Profile;
import Model.ProfileManager;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.matchers.Null;

import java.util.Scanner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by joshuakelley on 9/27/16.
 */
public class ProfileManagerTests {
    ProfileManager profileManager;
    Profile testProfile;

    @Before
    public void initialize(){
        profileManager=new ProfileManager();
        profileManager.addNewProfile("Josh","Kelley","Joshkelley19@gmail.com","joshkelley19","MaximumEffort!");
        testProfile=profileManager.profiles.get("joshkelley19");
    }

    @Test
    public void createProfileTest(){
        profileManager.addNewProfile("Tracy","McGrady","VCsCousin@seriously.com","TMac","BetterThanKobe");
        int expected=2;
        int actual=profileManager.profiles.size();
        assertEquals(expected,actual);
    }
    @Test
    public void userNameTakenTest0(){
        String takenUsername="joshkelley19";
        assertTrue(profileManager.userNameTaken(takenUsername));
    }
    @Test
    public void userNameTakenTest1(){
        String takenUsername="joSHkeLleY19";
        assertTrue(profileManager.userNameTaken(takenUsername));
    }
    @Test
    public void userNameTakenTest2(){
        String takenUsername="LebrahnJaymes";
        assertFalse(profileManager.userNameTaken(takenUsername));
    }
    @Test
    public void createIDTest(){
        for(int i = 0;i < 100;i++){
            assertTrue(profileManager.createID()<100000000&&profileManager.createID()>9999999);
        }
    }

    @Test
    public void signInUserNameMatchesPassword(){
        Profile actual = profileManager.signIn("joshkelley19","MaximumEffort!");
        assertEquals(testProfile,actual);
    }

    @Test(expected = NullPointerException.class)
    public void signInCredentialsNotExistent(){
        assertNull(profileManager.signIn("Nothing","Doing"));//todo figure out why
    }

    //should create 1000 unique ids from loop
    //set password length and specs
    //test profile added in list
    //
}
