package org.diagnosticcentre.reliablediagnosticcentreappbackend.Model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.CommonUserDetails;

@Entity
@Data  // Generates getters, setters, equals, hashCode, and toString()
@NoArgsConstructor
@AllArgsConstructor
public class Admin implements CommonUserDetails {
    @Id
    private int Admin_ID;
    private String Role = "ADMIN";
    @Column(unique = true)
    private String username;
    private String Admin_First_Name;
    private String Admin_Middle_Name;
    private String Admin_Last_Name;
    private String Admin_Email;
    private String Admin_Password;
    private String Admin_Phone;
    private String Admin_Address;
    @Override
    public String getRole() {
        return Role;
    }

    @PrePersist
    public void prePersist() {
        this.Role = "ADMIN";
        if (this.username == null || this.username.isBlank()) {
            this.username = "ADMIN" + this.Admin_ID;
        }
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return Admin_Password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
