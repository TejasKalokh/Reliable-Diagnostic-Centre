package org.diagnosticcentre.reliablediagnosticcentreappbackend.Controller.PatientCon;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientDetailsAndRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.PatientService.PatientService;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.ReceptionService.ReceptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patient")
@CrossOrigin(origins = "*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private ReceptionService receptionService;

    @PostMapping("/bookappoinment")
    public List<PatientDetailsAndRecords> bookAppoinment(@RequestBody PatientDetailsAndRecords patientRecords) {
       return receptionService.AddPatient(patientRecords);
    }

    @GetMapping("/report")
    public List<PatientRecords> getReportsPdf(@RequestBody PatientRecords patientId) {
        System.out.println(patientId + "From controller");
        return patientService.getReportsPdf(patientId.getPatient_Id());
    }
}
