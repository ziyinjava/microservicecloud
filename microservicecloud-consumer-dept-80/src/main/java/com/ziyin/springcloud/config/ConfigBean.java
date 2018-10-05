package com.ziyin.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ziyin
 @create 2018-10-2018/10/3-19:22
 */
@Configuration
public class ConfigBean
{
	/**
	 * RestTemplate提供了多种便捷访问远程Http服务的方法，
	 是一种简单便捷的访问restful服务模板类，是Spring提供的用于访问Rest服务的客户端模板工具集
	 * @return
	 */
	@Bean
	@LoadBalanced //Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端负载均衡的工具。
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

	@Bean
	public IRule myRule(){
		// 用随机算法替代默认的轮询
		return new RandomRule();
	}
}