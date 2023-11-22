package com.taskmanagement.TaskManagementService;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {
    // Additional cache-related configuration, if needed
	
	@Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(); // or use another CacheManager implementation
    }
}

