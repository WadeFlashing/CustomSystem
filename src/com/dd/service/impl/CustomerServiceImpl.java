package com.dd.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dd.dao.CustomerDao;
import com.dd.po.Customer;
import com.dd.service.CustomerService;
import com.itheima.common.utils.Page;

@Service("customerService")

public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	public Page<Customer> findCustomerList(Integer page,Integer rows,String custName,
			String custSource,String custIndustry,String custLevel){
		
		Customer customer = new Customer();
		if(StringUtils.isNotBlank(custName)){
			customer.setCus_name(custName);
		}
		if(StringUtils.isNotBlank(custSource)){
			customer.setCus_source(custSource);
		}
		if(StringUtils.isNotBlank(custIndustry)){
			customer.setCus_industry(custIndustry);
		}
		if(StringUtils.isNotBlank(custLevel)){
			customer.setCus_level(custLevel);
		}
		
		customer.setStart((page-1)*rows);
		customer.setRows(rows);
		
		List<Customer> customers = customerDao.selectCustomerList(customer);
		Integer count = customerDao.selectCustomerListCount(customer);
		Page<Customer> result = new Page<>();
		result.setPage(page);
		result.setRows(customers);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}
	
	//创建客户
	@Override
	public int createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}
	
	//通过id查询客户
	@Override
	public Customer getCustomerById(Integer id) {
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}
	
	//修改客户信息
	@Override
	@Transactional
	public int updateCustomer(Customer customer) {	
		return customerDao.updateCustomer(customer);
	}
	
	//删除客户
	@Override
	public int deleteCustomer(Integer id) {	
		return customerDao.deleteCustomer(id);
	}
	
}
