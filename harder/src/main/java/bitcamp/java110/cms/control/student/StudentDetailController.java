package bitcamp.java110.cms.control.student;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentDetailController {
    
    @RequestMapping("student/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 학생의 이메일 : ");
        String email = keyIn.nextLine();
        Student student = App.studentDao.findByEmail(email);
        
        if(student == null) {
            System.out.println("해당하는 메일 주소가 없습니다.");
            return;
        }
        
        System.out.printf("이름 : %s\n", student.getName());
        System.out.printf("이메일 : %s\n", student.getEmail());
        System.out.printf("암호 : %s\n", student.getPassword());
        System.out.printf("최종학력 : %s\n", student.getSchool());
        System.out.printf("전화 : %s\n", student.getTel());
        System.out.printf("재직여부 : %b\n", student.isWorking());
        
    }
}