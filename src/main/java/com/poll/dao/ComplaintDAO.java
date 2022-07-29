package com.poll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poll.models.Complaint;
import com.poll.util.ConnectionUtil;

public class ComplaintDAO {

	
	public void save(Complaint complaint) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into complaint (complaintBy,complaintOf,assignedTo, status) values(?,?,?,?)");
			statement.setInt(1, complaint.getComplaintBy());
			statement.setInt(2, complaint.getComplaintOf());
			statement.setString(1, complaint.getStatus());
			statement.setString(1, complaint.getAssignedTo());
		
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Complaint getComplaintBy(int id) {
		Complaint complaint = new Complaint();
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement("select * from complaint where id=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				complaint.setId(resultSet.getInt(1));
				complaint.setComplaintBy(resultSet.getInt(2));
				complaint.setComplaintOf(resultSet.getInt(3));
				complaint.setStatus(resultSet.getString(4));
				complaint.setAssignedTo(resultSet.getString(5));
				
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return complaint;
	}
	
}
