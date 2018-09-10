package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentAddController {
    
    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while(true) {
            Student m = new Student();
            
            System.out.print("이름 : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("이메일 : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("암호 : ");
            m.setPassword(keyIn.nextLine());
            
            System.out.print("최종학력 : ");
            m.setSchool(keyIn.nextLine());
            
            System.out.print("재직 여부 : ");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            
            System.out.print("전화 : ");
            m.setTel(keyIn.nextLine());
            
            App.students.add(m);
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    {
        Student m = new Student();
        m.setName("a");
        App.students.add(m);
        
        m = new Student();
        m.setName("b");
        App.students.add(m);
        
        m = new Student();
        m.setName("c");
        App.students.add(m);
        
        m = new Student();
        m.setName("d");
        App.students.add(m);
        
        m = new Student();
        m.setName("e");
        App.students.add(m);
    }
}