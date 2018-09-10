import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110.cms.annotaion.RequestMapping;
import bitcamp.java110.cms.context.ApplicationContext;

public class App {
/*  Annotation활용.
    RequestMapping을 통해 메소드 호출.
    
    Component와 RequestMapping 두개의 어노테이션으로 객체를 생성,
    student, teacher, manager 메소드 이름을 호출해서 메소드를 실행시킴. 
*/
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) throws Exception {
        ApplicationContext iocContainer = 
                new ApplicationContext("bitcamp.java110.cms.control");
        
        while(true) {
            String menu = prompt();
            
            if(menu.equals("exit")) {
                System.out.println("Bye!");
                break;
            }
            Object controller = iocContainer.getBean(menu);
            
            if(controller == null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            Method method = findRequestMapping(controller.getClass());
            
            if(method == null) {
                System.out.println("해당 메뉴가 없습니다.");
                continue;
            }
            method.invoke(controller, keyIn);
            //  method클래스의 method 강제 적용?
        }
        keyIn.close();
    }

    private static String prompt() {
        System.out.print("\n메뉴> ");
        String menu = keyIn.nextLine();
        return menu;
    }

    private static Method findRequestMapping(Class<?> clazz) {
        //  => 인자로 받은 클래스의 메소드 목록을 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods) {
            //  =>  메소드에서 @RequestMapping 정보를 추출한다.
            RequestMapping anno = m.getAnnotation(RequestMapping.class);
            
            if(anno != null)    //  찾았다면 이 메서드를 리턴한다.
                return m;
        }
        return null;
    }

}
