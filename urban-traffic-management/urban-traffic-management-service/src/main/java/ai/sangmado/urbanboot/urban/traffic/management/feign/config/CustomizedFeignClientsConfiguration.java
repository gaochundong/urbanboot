package ai.sangmado.urbanboot.urban.traffic.management.feign.config;

import ai.sangmado.urbanboot.urban.common.utils.Jackson;
import feign.Logger;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

@Configuration
public class CustomizedFeignClientsConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.BASIC;
    }

    @Bean
    public Encoder feignEncoder() {
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(Jackson.getObjectMapper());
        ObjectFactory<HttpMessageConverters> messageConverters = () -> new HttpMessageConverters(jacksonConverter);
        return new SpringEncoder(messageConverters);
    }

    @Bean
    public Decoder feignDecoder() {
        MappingJackson2HttpMessageConverter jacksonConverter = new MappingJackson2HttpMessageConverter(Jackson.getObjectMapper());
        ObjectFactory<HttpMessageConverters> messageConverters = () -> new HttpMessageConverters(jacksonConverter);
        return new OptionalDecoder(new ResponseEntityDecoder(new SpringDecoder(messageConverters)));
    }
}