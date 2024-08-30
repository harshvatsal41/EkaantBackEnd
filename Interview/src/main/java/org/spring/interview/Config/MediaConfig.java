package org.spring.interview.Config;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MediaConfig {

    @Bean
    public Cloudinary cloudinary(){

        Map config = new HashMap<>();
        config.put("cloud_name", "drq9yhh8l");
        config.put("api_key", "898735856926439");
        config.put("api_secret", "wP1yq_794dD77GLABpdZuc6QoEc");
        config.put("secure", true);
        return new Cloudinary(config);

    }
}
