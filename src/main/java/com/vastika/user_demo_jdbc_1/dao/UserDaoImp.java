package com.vastika.user_demo_jdbc_1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vastika.user_demo_jdbc_1.model.User;
import com.vastika.user_demo_jdbc_1.util.DBUtil;
import com.vastika.user_demo_jdbc_1.util.QueryUtil;

public class UserDaoImp implements UserDao {

	@Override
	public int saveUserInfo(User user) {
		int saved = 0;
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.INSERT_SQL)) {
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAddress());
			ps.setLong(4, user.getMobilenumber());

			saved = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return saved;
	}

	@Override
	public int updateUserInfo(User user) {
		int update = 0;
		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(QueryUtil.UPDATE_SQL);

		) {

			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getAddress());
			ps.setLong(4, user.getMobilenumber());
			ps.setInt(5, user.getId());

			update = ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return update;
	}

	@Override
	public void deleteuserInfo(int id) {
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.DELETE_SQL);) {
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getUserById(int id) {
		User user = new User();
		try (Connection con = DBUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(QueryUtil.GET_BY_ID_SQL);

		) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setAddress(rs.getString("address"));
				user.setMobilenumber(rs.getLong("mobile_no"));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUserInfo() {

		List<User> userList = new ArrayList<User>();
		try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(QueryUtil.LIST_SQL);

		) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setMobilenumber(rs.getLong("mobile_no"));
				userList.add(user);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

}
