import static org.junit.Assert.*;

import Model.EntryManager;
import kelley.josh.domain.JLockEntry;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by joshuakelley on 9/20/16.
 */
public class EntryManagerTests {
    JLockEntry testEntry;
    EntryManager entryManager;
    @Before
    public void initialize(){
        entryManager=new EntryManager();
        testEntry=entryManager.createNewEntry("Yahoo.com","fuddlefish","salmon",2);
    }

    @Test
    public void createNewEntryTest0(){
        int expected = 1;
        entryManager.createNewEntry("facebook.com","joshkelley19","HAMsandwich",1);
        int actual = entryManager.entries.size();
        assertEquals(expected,actual);
    }

    @Test
    public void createNewEntryTest1(){
        int expected = 2;
        entryManager.createNewEntry("myspace.com","joshkelley19","HAMsandwich",1);
        entryManager.createNewEntry("youtube.com","joshkelley19","youngmoney",2);
        int actual = entryManager.entries.size();
        assertEquals(expected,actual);
    }

    @Test
    public void deleteEntryTest(){
        entryManager.deleteEntry(testEntry);
        int expected = 0;
        int actual = entryManager.entries.size();
        assertEquals(expected,actual);
    }

    @Test
    public void editEntryTest(){
        entryManager.updatePassword(testEntry,"NewPassword");
        String expected = "NewPassword";
        String actual = testEntry.getPassword();
        assertEquals(expected,actual);
    }

//    @Test
//    public void showPasswordTest(){
//        entryManager.createNewEntry("myspace.com","joshkelley19","HAMsandwich",1);
//        entryManager.createNewEntry("youtube.com","joshkelley19","youngmoney",1);
//        System.out.println(entryManager.getAllEntries());
//    }



}
