package com.github.cloud.loadbalancer.ribbon.config;

import com.github.cloud.loadbalancer.ribbon.RibbonClientSpecification;
import com.github.cloud.loadbalancer.ribbon.RibbonLoadBalancerClient;
import com.github.cloud.loadbalancer.ribbon.SpringClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RibbonAutoConfiguration {
    @Autowired
    private List<RibbonClientSpecification> configurations = new ArrayList<>();

    @Bean
    public SpringClientFactory springClientFactory() {
        SpringClientFactory factory = new SpringClientFactory();
        factory.setConfigurations(this.configurations);
        return factory;
    }

    @Bean
    @ConditionalOnMissingBean(LoadBalancerClient.class)
    public LoadBalancerClient loadBalancerClient() {
        return new RibbonLoadBalancerClient(springClientFactory());
    }
}
