package bitcamp.java110.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110.cms.App;
import bitcamp.java110.cms.annotaion.Component;
import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    
    @RequestMapping("teacher/detail")
    public void detail(Scanner keyIn) {
        System.out.print("조회할 강사의 이메일 : ");
        String email = keyIn.nextLine();
        Teacher teacher = App.teacherDao.findByEmail(email);
        
        if(teacher == null) {
            System.out.println("해당하는 메일 주소가 없습니다.");
            return;
        }
        
        System.out.printf("이름 : %s\n", teacher.getName());
        System.out.printf("이메일 : %s\n", teacher.getEmail());
        System.out.printf("암호 : %s\n", teacher.getPassword());
        System.out.printf("전화 : %s\n", teacher.getTel());
        System.out.printf("급여 : %d\n", teacher.getPay());
        System.out.printf("과목 : %s\n", teacher.getSubject());
    }
}