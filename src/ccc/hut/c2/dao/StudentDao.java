package ccc.hut.c2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ccc.hut.c2.db.DBConn;
import ccc.hut.c2.model.Student;

public class StudentDao {
	Connection conn;
	public Student selectByReaderId(String readerId){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from student where readerId=?");
			pstmt.setString(1, readerId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Student stu = new Student();
				stu.setReaderId(rs.getString(1));
				stu.setName(rs.getString(2));
				stu.setSex(rs.getBoolean(3));
				stu.setBorn(rs.getDate(4));
				System.out.println(rs.getDate(4));
				stu.setSpec(rs.getString(5));
				stu.setNum(rs.getInt(6));
				stu.setSnum(rs.getInt(7));
				stu.setPhoto(rs.getBytes(8));
				return stu;
			}else{
				return null;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.closeConn();
		}
	}
	
	public void updateStudent(Student stu){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("update student set num=? where readerId=?");
			pstmt.setInt(1, stu.getNum());
			pstmt.setString(2, stu.getReaderId());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBConn.closeConn();
		}
	}
}







