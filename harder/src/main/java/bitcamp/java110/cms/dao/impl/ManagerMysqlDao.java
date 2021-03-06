package bitcamp.java110.cms.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.DaoException;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.util.DataSource;

public class ManagerMysqlDao implements ManagerDao {
    DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public int insert(Manager manager) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            
            stmt = con.createStatement();
            String sql1 = 
                    " insert into p1_memb(name, email, pwd, tel, cdt) "+
                    "values('" + manager.getName() +
                    "','" + manager.getEmail() + 
                    "',password('" + manager.getPassword() + 
                    "'),'" + manager.getTel() +
                    "',now())";
            
            System.out.println("\n" + sql1);
            stmt.executeUpdate(sql1, Statement.RETURN_GENERATED_KEYS);
            ResultSet autogeneratedKeys = stmt.getGeneratedKeys();
            autogeneratedKeys.next();
            int membNo = autogeneratedKeys.getInt(1);
            autogeneratedKeys.close();
            
            String sql2 =
                    "insert into p1_mgr(mrno,posi)" + 
                    " values(" + membNo +
                    ", '" + manager.getPosition() + 
                    "')";
            System.out.println(sql2 + "\n");
            stmt.executeUpdate(sql2);
            con.commit();
            
            return 1;
            
        }   catch (Exception e) {
            try {con.rollback();} catch (Exception e2) {}
                throw new DaoException(e);
        }   finally {
            try {stmt.close();} catch(Exception e) {    }
        }
    }

    @Override
    public List<Manager> findAll() throws DaoException {
        ArrayList<Manager> list = new ArrayList<>();
        
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql = " select " +
                    " m.mno, " +
                    " m.name, " +
                    " m.email, " +
                    " mr.posi " + 
                    " from p1_mgr mr " + 
                    " inner join p1_memb m on m.mno = mr.mrno";
            
            System.out.println("\n" + sql + "\n");
            rs = stmt.executeQuery(sql);
            
            while(rs.next()) {
                Manager mgr = new Manager();
                mgr.setNo(rs.getInt("mno"));
                mgr.setEmail(rs.getString("email"));
                mgr.setName(rs.getString("name"));
                mgr.setPosition(rs.getString("posi"));
                
                list.add(mgr);
            }
        }   catch(Exception e) {
                throw new DaoException(e);
        }   finally {
            try { rs.close(); } catch(Exception e) {   }
            try { stmt.close(); } catch(Exception e) {   }
        }
        return list;
    }

    @Override
    public Manager findByEmail(String email) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();

            String sql = " select m.mno, m.name, m.email, m.pwd, m.tel mr.posi" + 
                    " from p1_mgr mr" + 
                    " inner join p1_memb m on m.mno = mr.mrno" +            

                    " where m.email = '" + email + "'";
            
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                Manager m = new Manager();
                
                m.setNo(rs.getInt("mno"));
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setPassword(rs.getString("pwd"));
                m.setTel(rs.getString("tel"));
                m.setPosition(rs.getString("posi"));
                
                return m;
            }
            return null;
            
        }   catch (Exception e) {
                throw new DaoException(e);
        }   finally {
            try {rs.close();}catch(Exception e) {  }
            try {stmt.close();}catch(Exception e) {  }
        }
    }

    @Override
    public Manager findByNo(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = dataSource.getConnection();
            stmt = con.createStatement();
            
            String sql =
                    " select m.mno, m.name, m.email, m.pwd, m.tel, mr.posi " + 
                    " from p1_mgr mr " + 
                    " inner join p1_memb m on m.mno = mr.mrno " + 
                    " where m.mno =" + no;
            System.out.println("\n" + sql);
            rs = stmt.executeQuery(sql);
            
            if(rs.next()) {
                Manager m = new Manager();
                
                m.setNo(rs.getInt("mno"));
                m.setName(rs.getString("name"));
                m.setEmail(rs.getString("email"));
                m.setPassword(rs.getString("pwd"));
                m.setTel(rs.getString("tel"));
                m.setPosition(rs.getString("posi"));
                
                return m;
            }
            return null;
            
        }   catch (Exception e) {
                throw new DaoException(e);
        }   finally {
            try {rs.close();}catch(Exception e) {  }
            try {stmt.close();}catch(Exception e) {  }
        }
    }
    
    public int delete(int no) throws DaoException {
        Connection con = null;
        Statement stmt = null;
        
        try {
            con = dataSource.getConnection();
            con.setAutoCommit(false);
            stmt = con.createStatement();
            
            String sql1 = "delete from p1_mgr where mrno = " + no;
            System.out.println("\n" + sql1);
            int count = stmt.executeUpdate(sql1);
            
            if(count == 0) { return 0; }
            
            String sql2 = "delete from p1_memb where mno = " + no;
            System.out.println(sql2);
            stmt.executeUpdate(sql2);
            con.commit();
            
            return 1;
            
        }catch(Exception e) { 
            try {con.rollback();} catch (Exception e2) {}
                throw new DaoException(e);
        }finally {
            try {stmt.close();}catch(Exception e) {  }
        }
    }
}