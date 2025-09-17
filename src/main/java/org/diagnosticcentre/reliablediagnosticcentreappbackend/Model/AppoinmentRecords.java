package org.diagnosticcentre.reliablediagnosticcentreappbackend.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data  // Generates getters, setters, equals, hashCode, and toString()
@NoArgsConstructor
@AllArgsConstructor
public class AppoinmentRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Serial_Number;
    private Long Patient_Id;
    private String Patient_First_Name;
    private String Patient_Middle_Name;
    private String Patient_Last_Name;
    private String Gender;
    private int Age;
    private long Phone_Number;
    private LocalDate Test_Date;
    private LocalTime Test_Time;
    private String Test_Type;
}
