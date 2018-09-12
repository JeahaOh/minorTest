package bitcamp.java110.cms.dao;

public class MandatoryValueDaoExcecption extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public MandatoryValueDaoExcecption() {
        super();
    }

    public MandatoryValueDaoExcecption(String message, Throwable cause) {
        super(message, cause);
    }

    public MandatoryValueDaoExcecption(String message) {
        super(message);
    }
}
/*
RuntimeException
class 선언에서 exception안 받아도됨.(스텔스 기능임ㅋ)
코드가 간결해서 짜기는 편하지만 결국 처리 안하면,
Main까지 Exception올라감. 대책없이 정지함.
보고서가 CEO한테 한방에 올라가는거라고 생각하면 됨.
개발자 책임. 인생 리셋 버튼 누르는 날이 될지도 모름.
*/
/*
super();
상위 클래스의 생성자를 호출한다.
 a(){
    b();
}
 b(){
    c();
}
 c(){
 }
 test package로 직접 실행해 봐라.
호출은 올라가고 실행은 내려온다.
*/