package org.diagnosticcentre.reliablediagnosticcentreappbackend.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientDetailsAndRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Serial_Number;

    @Column(unique = true)
    private Long Patient_Id;

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
    @JsonProperty("age")
    private int Age;
    @JsonProperty("test_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate Test_Date;
    @JsonProperty("test_time")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime Test_Time;
    @JsonProperty("test_type")
    private String Test_Type;
    @JsonProperty("vist_type")
    private String Vist_Type;
    @JsonProperty("get_image_name")
    public String getImageName;
    @Lob // Use @Lob for large binary data
    @JsonProperty("prescription_image_data")
    private byte[] Prescription_Image_Data;
    @JsonProperty("address")
    private String Address;
    @JsonProperty("locality")
    private String Locality;
    @JsonProperty("password")
    private String Password;
    @JsonProperty("username")
    private String username;

}
