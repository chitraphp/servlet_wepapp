package com.veracity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.veracity.model.Employee;
import com.veracity.util.ConnectionFactory;

public class EmpDao {
	public boolean register(Employee e) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into employee values(?,?,?)");
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setInt(3, e.getSalary());

			int result = ps.executeUpdate();
			if (result == 1)
				return true;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	public boolean delete(int id) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from employee where id=?");

			ps.setInt(1, id);

			int result = ps.executeUpdate();
			if (result == 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(int id, int sal) {
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("update employee set salary=? where id=?");

			ps.setInt(1, sal);
			ps.setInt(2, id);

			int result = ps.executeUpdate();
			if (result == 1)
				return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Employee select(int id) {
		//Employee e;
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee where id=?");

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				
				Employee e = new Employee(rs.getInt("id"), rs.getInt("salary"), rs.getString("name"));
				return e;
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	public List<Employee> selectAll() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from employee");
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getInt("id"), rs.getInt("salary"), rs.getString("name")));
			}
			return list;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
