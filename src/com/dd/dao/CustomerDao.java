package com.dd.dao;

import java.util.List;

import com.dd.po.Customer;

public interface CustomerDao {
	//客户列表接口
	public List<Customer> selectCustomerList(Customer customer);
	
	//客户数接口
	public Integer selectCustomerListCount(Customer customer);
	
	//创建客户
	public int createCustomer(Customer customer);
	
	//通过id查询客户
	public Customer getCustomerById(Integer id);
	
	//修改客户
	public int updateCustomer(Customer customer);
	
	//删除客户
	public int deleteCustomer(Integer id);
}
