package com.ziyin.springcloud.controller;


import com.ziyin.springcloud.bo.Dept;
import com.ziyin.springcloud.servicce.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ziyin
 @create 2018-10-2018/10/3-18:37
 */

@RestController
public class DeptController {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private DeptService service;

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(@RequestBody Dept dept) {
		return service.add(dept);
	}

	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") Long id) {
		return service.get(id);
	}

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list() {
		return service.list();
	}


	@GetMapping("/dept/discovery")
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		System.out.println("########" + services);
		List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance instance : instances) {
			System.out.println(instance.getServiceId() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}
		return discoveryClient;
	}

}