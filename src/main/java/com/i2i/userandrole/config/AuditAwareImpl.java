package com.i2i.userandrole.config;

import org.springframework.data.domain.AuditorAware;
import java.util.Optional;

public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("System");
    }
}

