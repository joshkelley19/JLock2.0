package kelley.josh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
<<<<<<< HEAD

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
=======
>>>>>>> parent of fdaad38... minor additions
}
