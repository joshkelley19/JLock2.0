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
            uRepo.save(new JLockEntry("Google","joshkelley19","cleancode",1L));
            uRepo.save(new JLockEntry("MySpace","joshkelley19","cleancode",1L));
            uRepo.save(new JLockEntry("Email","joshkelley19","cleancode",1L));
            jRepo.save(new User("Josh","Kelley","jk@yahoo.com","joshkelley19","password",1L));
        };
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
