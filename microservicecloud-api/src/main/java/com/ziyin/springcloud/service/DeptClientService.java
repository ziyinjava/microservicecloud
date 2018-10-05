package com.ziyin.springcloud.service;

import com.ziyin.springcloud.bo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author ziyin
 @create 2018-10-2018/10/4-15:48
 */
//@FeignClient(value = "MICROSERVICECLOUD-DEPT")
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
	@RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list",method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add",method = RequestMethod.POST)
	public boolean add(Dept dept);
}
