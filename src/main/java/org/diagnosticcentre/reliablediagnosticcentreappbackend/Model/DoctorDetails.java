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

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data  // Generates getters, setters, equals, hashCode, and toString()
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDetails implements CommonUserDetails {
    @Id
    private int DoctorID;
    private String username;
    private String Doctor_Firts_Name;
    private String Doctor_Middle_Name;
    private String Doctor_Last_name;
    private String DoctorAddress;
    private long DoctorPhone;
    private String DoctorEmail;
    private String DoctorPassword;
    private String Role = "DOCTOR";

    public void setDocUsername(int DoctorId){
        this.username = String.valueOf(DoctorId);
    }
    @Override
    public String getRole() {
        return Role;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return DoctorPassword;
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
