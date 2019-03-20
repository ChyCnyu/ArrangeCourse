package me.merit.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUtil {
    @Value("${apikey}")
     String apikey;
}
