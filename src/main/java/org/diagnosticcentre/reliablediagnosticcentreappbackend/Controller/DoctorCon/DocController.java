package org.diagnosticcentre.reliablediagnosticcentreappbackend.Controller.DoctorCon;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.AppoinmentRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.DoctorService.DoctorService;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInput;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/doctor")
@CrossOrigin(origins = "*")
public class DocController {

    @Autowired
    DoctorService doctorService;

    @Autowired
    private ObjectMapper objectMapper;

    @GetMapping("/appoinment")
    public List<PatientRecords> Getappoinment() {
       return doctorService.GetAppoinment();
    }

    @GetMapping("/walkin")
    public List<PatientRecords> Getwalkin() {
        return doctorService.GetPatient();
    }

    @PostMapping(path = "/upload", consumes = {"multipart/form-data"})
    public String uploadPatient(@RequestPart(value = "file", required = true) MultipartFile report, @RequestParam(value = "patientphone" ,required = true) Long phone, @RequestParam(value = "patientname" , required = true) String name) throws IOException {
        System.out.println("File received: " + report.getOriginalFilename());
        System.out.println("JSON received: " + phone);
        System.out.println("JSON received: " + name);
        String res = doctorService.saveFile(report,phone,name);
        System.out.println("PDF into db");
        return res;
    }

}
