package com.dd.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dd.po.BaseDict;
import com.dd.po.Customer;
import com.dd.po.User;
import com.dd.service.BaseDictService;
import com.dd.service.CustomerService;
import com.itheima.common.utils.Page;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
	
	@Value("${customer.from.type}")
	private String FROM_TYPE;
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	
	@RequestMapping(value="/customer/list")
	public String list(@RequestParam(defaultValue="1") Integer page,@RequestParam(defaultValue="10") Integer rows,
			String custName,String custSource,String custIndustry,String custLevel,Model model){
		Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
		model.addAttribute("page", customers);
		
		List<BaseDict> fromType = baseDictService.findBaseDictByTypeCode(FROM_TYPE);
		List<BaseDict> industryType = baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
		List<BaseDict> levelType = baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
		
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		return "customer";
		
	}
	
//创建客户
	@RequestMapping(value="/customer/create")
	@ResponseBody
	public String customerCreate(Customer customer,HttpSession session){
			User user = (User)session.getAttribute("USER_SESSION");
			customer.setCus_create_id(user.getUser_id());
			Date date = new Date();
			Timestamp timestamp = new Timestamp(date.getTime());
			customer.setCus_createtime(timestamp);
			int rows = customerService.createCustomer(customer);
			if(rows>0){
				return "OK";
			}else {
				return "FAIL";
			}
	}
	
	//通过id查询客户信息
	@RequestMapping(value="/customer/getCustomerById")
	@ResponseBody
	public Customer getCustomerById(Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	//修改客户信息
	@RequestMapping(value="/customer/update")
	@ResponseBody
	public String updateCustomer(Customer customer) {	
		int rows = customerService.updateCustomer(customer);
		if(rows>0){
			return "OK";
		}else {
			return "FAIL";
		}
	}	
	
	//删除客户
	@RequestMapping(value="/customer/deletes")
	@ResponseBody
	public String deleteCustomer(Integer id){
		int rows = customerService.deleteCustomer(id);
		if(rows>0){
			return "OK";
		}else {
			return "FAIL";
		}
	}
	
}
