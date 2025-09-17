package org.diagnosticcentre.reliablediagnosticcentreappbackend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.CommonUserDetails;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data  // Generates getters, setters, equals, hashCode, and toString()
@NoArgsConstructor
@AllArgsConstructor
public class ReceptionDetails implements CommonUserDetails {
    @Id
    private int Reception_Id;
    private String Reception_First_Name;
    private String Reception_Middle_Name;
    private String Reception_Last_Name;
    private String Reception_Address;
    private long Reception_Phone;
    private String Reception_Email;
    private String Password;
    private String username;
    private String Role = "RECEPTION";
    @Override
    public String getRole() {
        return Role;
    }

    public void setUsername(int Reception_Id) {
        this.username = String.valueOf(Reception_Id);
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return Password;
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
