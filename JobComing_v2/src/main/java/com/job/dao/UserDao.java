package com.job.dao;

import com.job.bean.User;

public interface UserDao {
	/**
	 * �����û�id����ѯһ���򵥵�userId
	 * @param userId
	 * @return
	 */
	public User getUserByUserId(int userId);

	/**
	 * �����û���������һ���򵥵��û�
	 * @param userName
	 */
	public User getUserByUserName(String userName);
	
	/**
	 * �����û�ͷ��
	 * @param avatar
	 */
	public void updateUserAvatar(String avatar);
	
	/**
	 * �����û�����
	 * @param score
	 */
	public void updateUserScore(int score);
	
	/**
	 * �����û�����
	 * @param user
	 */
	public void updateUser(User user);
}
