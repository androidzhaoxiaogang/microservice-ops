package com.yonyou.dmc.service.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.dexcoder.dal.spring.page.PageControl;

@Configuration
public class PageConfig {

	@Bean
	public PageControl pageControl() throws Exception {
		PageControl pageControl = new PageControl();
		return pageControl;
	}
}
