package com.job.dao;

import java.util.List;

import com.job.bean.Evaluate;

public interface EvaluateDao {
	/**
	 * �������۶�������
	 * @param evaluate
	 */
	public void insert(Evaluate evaluate);
	/**
	 * �������۱��ɾ������
	 * @param evaluateId
	 */
	public void delete(int evaluateId);
	/**
	 * ͨ���û�id�������е�����
	 * @param userId
	 * @return
	 */
	public List<Evaluate> getEvaluateByUserId(int userId);
	/**
	 * ͨ�����������˵�id�������ж���������
	 * @param userId
	 * @return
	 */
	public List<Evaluate>getEvaluateByJobUserId(int userId);
}
