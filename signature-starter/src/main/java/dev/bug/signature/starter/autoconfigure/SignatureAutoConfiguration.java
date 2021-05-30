package dev.bug.signature.starter.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("dev.bug.signature.starter")
@ConditionalOnProperty(value = "demo.signature.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(SignatureProperties.class)
public class SignatureAutoConfiguration {
}
