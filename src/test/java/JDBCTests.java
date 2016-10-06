import Model.JDBC;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by joshuakelley on 10/6/16.
 */
public class JDBCTests {
    JDBC jdbc;
    @Before
    public void initialize(){
        jdbc = new JDBC();
        jdbc.addProfile(17,"Freeman","Keith","kfreeman@gmail","K_F","mmeeeehhhh");
    }

    @Test
    public void getProfileTest(){

    }
}
