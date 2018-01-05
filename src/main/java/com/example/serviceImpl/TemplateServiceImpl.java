package com.example.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.service.TemplateService;

import net.sf.ehcache.CacheManager;

@Service
public class TemplateServiceImpl implements TemplateService {
	@Autowired
	CacheManager cacheManager;

}
