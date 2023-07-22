package com.example.ecommerce.config;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsuporrtedActions = {HttpMethod.POST, HttpMethod.PUT, HttpMethod.DELETE};

        // Disable HTTP method for Product.
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(unsuporrtedActions))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsuporrtedActions)));

        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsuporrtedActions)))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(unsuporrtedActions));
    }
}
