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
public class PatientRecords {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UUID;

    @JsonProperty("patient_id")
    private Long patient_Id;
    @JsonProperty("phone_number")
    private Long phone_Number;
    @JsonProperty("patient_first_name")
    private String patient_First_Name;
    @JsonProperty("patient_middle_name")
    private String patient_Middle_Name;
    @JsonProperty("patient_last_name")
    private String patient_Last_Name;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("age")
    private int age;
    @JsonProperty("test_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate test_Date;
    @JsonProperty("test_time")
    @JsonFormat(pattern = "HH:mm")
    private LocalTime test_Time;
    @JsonProperty("test_type")
    private String test_Type;
    @JsonProperty("visit_type")
    private String vist_Type;
    @JsonProperty("image_Name")
    private String imageName;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @JsonProperty("prescription_image_data")
    private byte[] prescription_Image_Data;
    @JsonProperty("status")
    private String status;
    @JsonProperty("file_name")
    private String fileName;
    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    @JsonProperty("reports_pdf")
    private byte[] reportsPdf;
    @JsonProperty("test_type")
    public String getTest_Type() {
        return test_Type;
    }

    @JsonProperty("test_time")
    public LocalTime getTest_Time() {
        return test_Time;
    }


}