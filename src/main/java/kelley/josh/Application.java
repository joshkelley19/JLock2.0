package kelley.josh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    @RequestMapping("/")
//    public String homePage(){
//        return "My App is working, kinda";
//    }

    @RequestMapping("/")
    public String tester(){
        StringBuilder htmlHomePage = new StringBuilder();
        File file = new File("src/main/resources/public/index.html");

        try {
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
                htmlHomePage.append(scan.nextLine());
            }
                }catch (IOException e){
                e.printStackTrace();
            }
        return htmlHomePage.toString();
    }
}
