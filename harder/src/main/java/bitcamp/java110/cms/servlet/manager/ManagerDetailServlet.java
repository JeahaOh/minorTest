package bitcamp.java110.cms.servlet.manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@WebServlet("/manager/detail")
public class ManagerDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int no = Integer.parseInt(request.getParameter("no"));
        
        ManagerDao managerDao = (ManagerDao) this.getServletContext()
                .getAttribute("managerDao");
        
        Manager manager = managerDao.findByNo(no);
        
        if(manager == null) {
            out.println("해당하는 번호가 없습니다.");
            return;
        }
        
        out.printf("\n회원번호 : %d\n", manager.getNo());
        out.printf("이름 : %s\n", manager.getName());
        out.printf("이메일 : %s\n", manager.getEmail());
        out.printf("암호 : %s\n", manager.getPassword());
        out.printf("전화 : %s\n", manager.getTel());
        out.printf("직위 : %s\n", manager.getPosition());
    }
}

