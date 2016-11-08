package com.job.dao;

import com.job.bean.AddressProvince;

public interface ProvinceDao {
  /**
   * ͨ��ʡ�����Ʒ���һ��ʡ�ݶ���
   * @param name
   * @return
  */
  public AddressProvince getProvinceByName(String name);
  /**
   * ͨ��ʡ�ݱ�ŷ���һ��ʡ�ݶ���
   * @param code
   * @return
   */
  public AddressProvince getProvinceByCode(int code);
}
