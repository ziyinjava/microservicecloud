package com.ziyin.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ziyin.springcloud.bo.Dept;
import com.ziyin.springcloud.servicce.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ziyin
 @create 2018-10-2018/10/3-18:37
 */

@RestController
public class DeptController
{
	@Autowired
	private DeptService service = null;

	@RequestMapping(value="/dept/get/{id}",method= RequestMethod.GET)
	// 一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Dept get(@PathVariable("id") Long id)
	{
		Dept dept =  this.service.get(id);
		if(null == dept)
		{
			throw new RuntimeException("该ID："+id+"没有没有对应的信息");
		}
		return dept;
	}

	public Dept processHystrix_Get(@PathVariable("id") Long id)
	{
		return new Dept().setDeptno(id)
				.setDname("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
				.setDb_source("no this database in MySQL");
	}
}