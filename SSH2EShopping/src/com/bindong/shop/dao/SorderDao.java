package com.bindong.shop.dao;

import java.util.List;

import com.bindong.shop.model.Sorder;

public interface SorderDao extends BaseDao<Sorder> {
		//查询热点商品的销售量
		public List<Object> querySale(int number);
}
