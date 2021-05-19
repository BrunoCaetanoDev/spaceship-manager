package com.training.springboot.spaceover.spaceship.manager.configuration;

import com.training.springboot.spaceover.spaceship.manager.utils.interceptors.HttpHeaderEnrichmentInterceptor;
import com.training.springboot.spaceover.spaceship.manager.utils.interceptors.HttpLoggerInterceptor;
import com.training.springboot.spaceover.spaceship.manager.utils.interceptors.MdcInitInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Profile("test")
public class SpaceshipManagerWebConfiguration implements WebMvcConfigurer {

    @Autowired
    private MdcInitInterceptor mdcInitHandler;

    @Autowired
    private HttpHeaderEnrichmentInterceptor headerEnrichmentHandlerInterceptor;

    @Autowired
    private HttpLoggerInterceptor httpLoggerInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mdcInitHandler);
        registry.addInterceptor(headerEnrichmentHandlerInterceptor);
        registry.addInterceptor(httpLoggerInterceptor);
    }

}
