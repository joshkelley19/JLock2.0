import Model.Profile;
import Model.ProfileManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshuakelley on 9/27/16.
 */
public class ProfileManagerTests {
    ProfileManager profileManager;

    @Before
    public void initialize(){
        profileManager=new ProfileManager();
        profileManager.addNewProfile("Josh","Kelley","joshkelley19","MaximumEffort!");
    }
    @Test
    public void createProfileTest(){
        profileManager.addNewProfile("Tracy","McGrady","TMac","BetterThanKobe");
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
        assertTrue(profileManager.createID()<100000000&&profileManager.createID()>9999999);
    }
}
