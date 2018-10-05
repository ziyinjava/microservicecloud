package com.ziyin.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ziyin
 @create 2018-10-2018/10/4-12:45
 */
@Configuration
public class MySelfRule {

	@Bean
	public IRule myRule(){
		return new RoundRobinRule_ZIYIN();
	}
}
