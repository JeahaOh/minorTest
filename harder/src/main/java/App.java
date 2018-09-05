import java.util.Scanner;

public class App {
    //  여러 속성값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용.
    static class Member{
        protected String name;
        protected String email;
        protected String password;
        
        public String getName() {
            return name;
        }
        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public void setPassword(String password) {
            this.password = password;
        }
    }

    static Member[] members = new Member[100];
    
    static int index = 0;
    
    static Scanner keyIn = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        while(true) {
            String menu = promptMenu();
            
            if(menu.equals("1")) {
                seviceStudentMenu();
            }   else if(menu.equals("0")) {
                System.out.println("Bye!");
                break;
            }
        }
        
        keyIn.close();
        
    }

    private static void seviceStudentMenu() {
        while(true) {
            System.out.println("학생관리>");
            String command = keyIn.nextLine();
            
            if(command.equals("list")) {
                printMembers();
            }   else if(command.equals("add")){
                inputMembers();
            }   else if(command.equals("quit")) {
                break;
            }   else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }

    private static String promptMenu() {
        System.out.println("[메뉴]");
        System.out.println("1.학생 관리");
        System.out.println("2.강사 관리");
        System.out.println("3.매니져 관리");
        System.out.println("0.종료");
        
        while(true) {
            System.out.println("메뉴 번호>");
            
            String menu = keyIn.nextLine();
            
            switch(menu) {
            case "1" :
            case "2" :
            case "3" :
            case "0" :
                return menu;
            default : 
                System.out.println("메뉴 번호가 유효하지 않습니다.");
            }
        }
    }
    
    static void printMembers() {
        for(int i = 0; i < index; i++) {
            System.out.printf("%s, %s, %s \n", members[i].getName(), members[i].getEmail(), members[i].getPassword());                
        }
    }
    
    static void inputMembers() {
        while(true) {
            Member m = new Member();
            
            System.out.print("Name : ");
            m.setName(keyIn.nextLine());
            
            System.out.print("eMail : ");
            m.setEmail(keyIn.nextLine());
            
            System.out.print("Password : ");
            m.setPassword(keyIn.nextLine());
            
            members[index++] = m;
            
            System.out.print("\nContinue? ( Y/n )");
            String answer = keyIn.nextLine();
            if(answer.toLowerCase().equals("n")) {
                break;
            }
        }
    }
    
    
}
