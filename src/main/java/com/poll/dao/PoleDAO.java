package com.poll.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.poll.models.Pole;
import com.poll.util.ConnectionUtil;

public class PoleDAO {

	public void save(Pole pole) {
		Connection connection = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement("insert into user (address) values(?)");
			statement.setString(1, pole.getAddress());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Pole getPoleById(int id) {
		Pole pole = new Pole();
		Connection connection = ConnectionUtil.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement("select * from pole where id=?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				pole.setId(resultSet.getInt(1));
				pole.setAddress(resultSet.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pole;
	}

}
