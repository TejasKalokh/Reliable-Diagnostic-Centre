package org.diagnosticcentre.reliablediagnosticcentreappbackend.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Data  // Generates getters, setters, equals, hashCode, and toString()
@NoArgsConstructor
@AllArgsConstructor
public class FrontendPatientData {
    @Id
    private int patientId;
    private String firstName;
    private String testname;
    private LocalTime testtime;
    private int age;
}
