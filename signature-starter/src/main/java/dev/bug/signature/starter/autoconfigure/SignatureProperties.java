package dev.bug.signature.starter.autoconfigure;

import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.Duration;

@Validated
@ConfigurationProperties(prefix = "demo.signature")
public class SignatureProperties {

    /**
     * Username for email signature
     */
    @NotBlank
    @Size(min = 5, max = 100)
    private String username = "NONAME";

    @Valid
    @NestedConfigurationProperty
    private Extra extra = new Extra();

    public String getUsername() {
        return username;
    }

    public SignatureProperties setUsername(String username) {
        this.username = username;
        return this;
    }

    public Extra getExtra() {
        return extra;
    }

    public SignatureProperties setExtra(Extra extra) {
        this.extra = extra;
        return this;
    }

    public static class Extra {

        /**
         * Retention period for email
         */
        @DurationMin(minutes = 5)
        @DurationMax(hours = 1)
        private Duration retentionPeriod = Duration.ofMinutes(5);

        public Duration getRetentionPeriod() {
            return retentionPeriod;
        }

        public Extra setRetentionPeriod(Duration retentionPeriod) {
            this.retentionPeriod = retentionPeriod;
            return this;
        }
    }
}
