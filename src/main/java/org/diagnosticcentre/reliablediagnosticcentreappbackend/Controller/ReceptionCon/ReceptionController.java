package org.diagnosticcentre.reliablediagnosticcentreappbackend.Controller.ReceptionCon;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientDetailsAndRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.TestDetails;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.PatientDetailsRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.TestRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.ReceptionService.QRCodeService;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.ReceptionService.ReceptionService;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.ReceptionService.UPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reception")
@CrossOrigin(origins = "*")
public class ReceptionController {
    @Autowired
    ReceptionService receptionService;

    @Autowired
    private UPIService upiService;

    @Autowired
    private PatientDetailsRepo patientRecords;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private TestRepo testRepo;

    @PostMapping("/addpatient")
    public List<PatientDetailsAndRecords> addPatient(@RequestBody PatientDetailsAndRecords patientDetailsAndRecords) {
        System.out.println("Received payload: " + patientDetailsAndRecords);
        return receptionService.AddPatient(patientDetailsAndRecords);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createpayment(@RequestBody TestDetails testname) {
        return receptionService.createPayment(testname);
    }

    @GetMapping("/walkinpatient")
    public List<PatientRecords> walkinpatient() {
        return receptionService.getwalkinpatient();
    }

    @GetMapping("/appoinmentpatient")
    public List<PatientRecords> appoinmentpatient() {
        return receptionService.getappoinmentpatient();
    }

    @GetMapping("/getalltests")
    public List<TestDetails> getest() {
        return receptionService.getTestDetails();
    }
}

