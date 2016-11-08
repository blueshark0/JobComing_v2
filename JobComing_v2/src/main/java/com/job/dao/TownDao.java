package com.job.dao;
import java.util.List;

import com.job.bean.AddressTown;

public interface TownDao {
	/**
	 * ͨ�����ص����ַ������ض���
	 * @param name
	 * @return
	 */
	public AddressTown getTownByName(String townName);
	/**
	 * ͨ�����صı�ŷ������ض���
	 * @param townCode
	 * @return
	 */
	public AddressTown getTownByCode(int townCode );
	/**
	 * ͨ�����еı��뷵�����������صļ���
	 * @param cityCode
	 * @return
	 */
	public List<AddressTown> getTownListByCity(int cityCode);
}
