package org.eezer.service.config;

import java.util.HashSet;
import java.util.Set;

import org.eezer.service.converter.UserDTO2UserModelConverter;
import org.eezer.service.converter.UserModel2UserDTOConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

@Configuration
public class ConversionServiceConfig {

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        bean.setConverters(this.getConverters());
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    private Set<Converter<?, ?>> getConverters() {
        Set<Converter<?, ?>> converters = new HashSet();

        converters.add(new UserDTO2UserModelConverter());
        converters.add(new UserModel2UserDTOConverter());

        return converters;
    }

}
