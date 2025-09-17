package org.diagnosticcentre.reliablediagnosticcentreappbackend.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  // Generates getters, setters, equals, hashCode, and toString()
@NoArgsConstructor
@AllArgsConstructor
public class TestDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonProperty("testname")
    private String testname;
    @JsonProperty("testcharge")
    private int testcharge;
    @JsonProperty("sub_testname")
    private String SubTestname;
    @JsonProperty("sub_sub_testdescription")
    private String SubSubTestdescription;
    @JsonProperty("sub_sub_testname")
    private String SubSubTestname;
}
