package kelley.josh;

import kelley.josh.domain.JLockEntry;
import kelley.josh.domain.User;
import kelley.josh.repositories.JLockEntryRepository;
import kelley.josh.repositories.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    @Bean
    InitializingBean saveData(JLockEntryRepository uRepo, UserRepository jRepo){//method returning an initializing bean
        return () -> {
            jRepo.save(new User("Josh","Kelley","jk@yahoo.com","joshkelley19","password",1L));
            uRepo.save(new JLockEntry("Google","joshkelley19","cleancode",1L));
            uRepo.save(new JLockEntry("MySpace","joshkelley19","cleancode",1L));
            uRepo.save(new JLockEntry("Email","joshkelley19","cleancode",1L));
            jRepo.save(new User("Leroy","Jenkins","Leroy@aim.com","LEROY","JENKINS",2L));
            uRepo.save(new JLockEntry("Google","leroy19203","wowsuchgame",2L));
            uRepo.save(new JLockEntry("MySpace","leroy19203","wowsuchgame",2L));
            uRepo.save(new JLockEntry("Email","leroy19203","wowsuchgame",2L));
            jRepo.save(new User("YoungMonty","DeWilmington","hipsdontlie@gmail.com","professorx","tabs2016",3L));
            uRepo.save(new JLockEntry("Google","lieutenantdan4eva","insertpunhere",3L));
            uRepo.save(new JLockEntry("MySpace","lieutenantdan4eva","insertpunhere",3L));
            uRepo.save(new JLockEntry("Email","lieutenantdan4eva","insertpunhere",3L));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
