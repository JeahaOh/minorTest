package bitcamp.java110.cms.domain;

public class Teacher extends Member{
    protected String tel;
    protected int pay;
    protected String subject;
    
    public String getTel() {
        return tel;
    }
    public int getPay() {
        return pay;
    }
    public String getSubject() {
        return subject;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setPay(int pay) {
        this.pay = pay;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
}
