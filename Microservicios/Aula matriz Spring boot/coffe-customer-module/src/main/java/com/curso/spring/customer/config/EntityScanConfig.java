package com.curso.spring.customer.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan("package com.curso.spring.common.estities")
public class EntityScanConfig {

}
