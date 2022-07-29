package com.poll.dao;

import java.sql.Connection;

import com.poll.models.User;
import com.poll.util.ConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class UserDAO {
	public void save(User user) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection
					.prepareStatement("insert into user (name,email,password,isAdmin,address) values(?,?,?)");
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3,  user.getPassword());;
			statement.setBoolean(4, user.isAdmin());
			statement.setString(5, user.getAddress());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User findUserById(int id) {
		User user = new User();
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement("select * from user where id=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setAdmin(resultSet.getBoolean(5));
				user.setAddress(resultSet.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User findUserByEmail(String email) {
		User user = new User();
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement("select * from user where email=?");
			statement.setString(1, email);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setAdmin(resultSet.getBoolean(5));
				user.setAddress(resultSet.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
}
