package org.diagnosticcentre.reliablediagnosticcentreappbackend.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
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
public class PatientDetails implements CommonUserDetails {
    private Long Patient_Id;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Serial_Number;
    @JsonProperty("phone_number")
    private long Phone_Number;
    @JsonProperty("patient_first_name")
    private String Patient_First_Name;
    @JsonProperty("patient_middle_name")
    private String Patient_Middle_Name;
    @JsonProperty("patient_last_name")
    private String Patient_Last_Name;
    @JsonProperty("gender")
    private String Gender;
    private String username;
    @JsonProperty("age")
    private int Age;
    @JsonProperty("address")
    private String Address;
    @JsonProperty("locality")
    private String Locality;
    @JsonProperty("password")
    private String Password;
    private String Role = "PATIENT";

    @Override
    public String getRole() {
        return Role;
    }

    public void setUsername(int Patient_Id) {
        this.username = String.valueOf(Patient_Id);
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
