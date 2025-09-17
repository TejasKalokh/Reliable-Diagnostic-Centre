package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

public interface CommonUserDetails extends UserDetails {
    String getRole();

    @Override
    default Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + getRole()));
    }
}