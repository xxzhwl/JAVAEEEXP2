package ccc.hut.c2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ccc.hut.c2.db.DBConn;
import ccc.hut.c2.model.Lend;

public class LendDao {
	
	public Connection conn;
	public List selectLend(String readerId,int pageNow,int pageSize){
		try{
			conn=DBConn.getConn();
			List ls=new ArrayList();
			PreparedStatement pstmt=
			conn.prepareStatement
			("select top "+pageSize+"l.bookId,l.ISBN,b.bookName,b.publisher,b.price,l.ltime from lend as l,book as b where readerId=? and b.ISBN=l.ISBN and l.bookId not in (select top "+pageSize*(pageNow-1)+" l.bookId from lend as l)");
			pstmt.setString(1, readerId);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setISBN(rs.getString(2));
				lend.setBookName(rs.getString(3));
				lend.setPublisher(rs.getString(4));
				lend.setPrice(rs.getFloat(5));
				lend.setLTime(rs.getDate(6));
				ls.add(lend);
			}
			return ls;
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
	public int selectLendSize(String readerId){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select count(*) from lend where readerId=?");
			pstmt.setString(1, readerId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				int pageCount=rs.getInt(1);
				return pageCount;
			}
			return 0;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}finally{
			DBConn.closeConn();
		}
	}
	public Lend selectByBookId(String bookId){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from lend where bookId=?");
			pstmt.setString(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setReaderId(rs.getString(2));
				lend.setISBN(rs.getString(3));
				lend.setLTime(rs.getDate(4));
				return lend;
			}else
				return null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.closeConn();
		}
	}
	public boolean addLend(Lend lend){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("insert into lend values(?,?,?,?)");
			pstmt.setString(1, lend.getBookId());
			pstmt.setString(2, lend.getReaderId());
			pstmt.setString(3, lend.getISBN());
			pstmt.setDate(4, new Date(lend.getLTime().getTime()));
			pstmt.execute();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			DBConn.closeConn();
		}
	}
	public Lend selectByBookISBN(String ISBN){
		try{
			conn = DBConn.getConn();
			PreparedStatement pstmt = conn.prepareStatement("select * from lend where ISBN=?");
			pstmt.setString(1, ISBN);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				Lend lend = new Lend();
				lend.setBookId(rs.getString(1));
				lend.setReaderId(rs.getString(2));
				lend.setISBN(rs.getString(3));
				lend.setLTime(rs.getDate(4));
				return lend;
			}else{
				return null;
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBConn.closeConn();
		}
	}
}
