package bitcamp.java110.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerAddController {
    
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while(true) {
            Manager m = new Manager();
            
            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("전화 : ");
            m.setTel(keyIn.nextLine());
            
            System.out.print("직위 : ");
            m.setPosition(keyIn.nextLine());
            
            App.managers.add(m);
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    {
        Manager m = new Manager();
        m.setName("a");
        App.managers.add(m);
        
        m = new Manager();
        m.setName("b");
        App.managers.add(m);
        
        m = new Manager();
        m.setName("c");
        App.managers.add(m);
        
        m = new Manager();
        m.setName("d");
        App.managers.add(m);
        
        m = new Manager();
        m.setName("e");
        App.managers.add(m);
    }
}