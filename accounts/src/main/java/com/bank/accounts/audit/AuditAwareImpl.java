package com.bank.accounts.audit;

import org.springframework.data.domain.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
       return Optional.of("ACCOUNT.MS");
    }
}
