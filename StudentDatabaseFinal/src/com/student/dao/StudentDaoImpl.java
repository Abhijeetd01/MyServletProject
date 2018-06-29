package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.studentproject.bean.StudentBean;
import com.studentproject.util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	private Connection conn;
	
	public StudentDaoImpl() {
		conn=DBUtil.getConnect();
	}
	
	
	@Override
	public StudentBean getStudentDetails(int roll) {
		
		StudentBean bean=null;
		
		
		try {
			PreparedStatement ps=conn.prepareStatement("select * from student where roll=?");
			
			ps.setInt(1,roll);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()){
				
				int r=rs.getInt(1);
				String n=rs.getString(2);
				int m=rs.getInt(3);
				
				bean=new StudentBean(r, n, m);
				
			}
			
			
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return bean;
		
	}

}
