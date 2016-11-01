package kelley.josh.controller;

import kelley.josh.domain.JLockEntry;
import kelley.josh.repositories.JLockEntryRepository;
import kelley.josh.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by joshuakelley on 9/22/16.
 */
@RestController("/")
public class Controller {
    @Autowired
    UserRepository userRepository;

    @Autowired
    JLockEntryRepository jLockEntryRepository;

    @RequestMapping(value = "entries", method = RequestMethod.GET)
    public List<JLockEntry> getEntries(Long id){
        return jLockEntryRepository.findById(id);
    }

    @RequestMapping(value = "delete", method = RequestMethod.DELETE)
    public JLockEntry deleteEntry(Long id){
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


}
