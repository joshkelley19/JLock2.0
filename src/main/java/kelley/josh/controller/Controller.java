package kelley.josh.controller;

import kelley.josh.domain.JLockEntry;
import kelley.josh.domain.User;
import kelley.josh.repositories.JLockEntryRepository;
import kelley.josh.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by joshuakelley on 9/22/16.
 */
@RestController("/")
public class Controller {
//    User currentUser;
    @Autowired
    UserRepository userRepository;

    @Autowired
    JLockEntryRepository jLockEntryRepository;

//    @Autowired
//    JdbcTemplate jdbcTemplate;

//    @RequestMapping("signin")
//    public User signIn(@RequestBody ){
//        currentUser = findUser(String userName, String password);
//        return currentUser;
//    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public User createUser(@RequestBody User user) {
        userRepository.save(user);
        return userRepository.findOne(user.getAccountNumber());
    }

    @RequestMapping(value = "entries/{id}", method = RequestMethod.GET)
    public List<JLockEntry> getEntries(@PathVariable Long id){
        return jLockEntryRepository.findByClientAccountNumber(id);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public JLockEntry deleteEntry(@PathVariable Long id){
        JLockEntry deletedEntry = jLockEntryRepository.findOne(id);
        jLockEntryRepository.delete(deletedEntry);
        return deletedEntry;
    }

    @RequestMapping(value = "entries", method = RequestMethod.PUT)
    public JLockEntry updateEntry(@RequestBody JLockEntry entry){
        return jLockEntryRepository.saveAndFlush(entry);//update?
    }

    @RequestMapping(value = "entries", method = RequestMethod.POST)
    public JLockEntry createEntry(JLockEntry jLockEntry){
        return jLockEntryRepository.save(jLockEntry);
    }

    @RequestMapping(value = "scheme/{length}", method = RequestMethod.GET)
    public String createEntry(@PathVariable int length){
        return PasswordManager.createPasswordScheme(length);
    }

    @RequestMapping(value = "custom", method = RequestMethod.GET)
    public ResponseEntity<String> createCustomEntry(int[] specs){
        String response = PasswordManager.createCustomPasswordScheme(specs);
        if(response.isEmpty())return new ResponseEntity<>(response, HttpStatus.SEE_OTHER);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




//    ++++++++++++++++++++++++++++++++++++++     For Testing              +++++++++++++++++++++++++++++++++++++++++++++++++

    @RequestMapping(value = "entry/{id}", method = RequestMethod.GET)
    public JLockEntry getEntry(@PathVariable Long id){
        return jLockEntryRepository.findOne(id);
    }
}
