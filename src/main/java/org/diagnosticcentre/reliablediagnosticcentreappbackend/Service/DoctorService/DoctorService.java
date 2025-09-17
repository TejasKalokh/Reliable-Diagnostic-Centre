package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.DoctorService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.AppoinmentRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.AppoinmentRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.PatientRecorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class DoctorService {
    @Autowired
    private AppoinmentRepo appoinmentRepo;

    @Autowired
    private PatientRecorRepo patientRecorRepo;

    //All Appoinments
    public List<PatientRecords> GetAppoinment() {
        List<PatientRecords> appoinments = new ArrayList<>();
        for (PatientRecords a : patientRecorRepo.findAll()) {
            if(a.getTest_Date().equals(LocalDate.now())) {
                if(a.getVist_Type().equals("Appoinment")) {
                    appoinments.add(a);
                }
            }
        }
        return appoinments;
    }

    //All Walkin
    public List<PatientRecords> GetPatient() {
        List<PatientRecords> patients = new ArrayList<>();
        for (PatientRecords p : patientRecorRepo.findAll()) {
            if(p.getTest_Date().equals(LocalDate.now())) {
                if (p.getVist_Type().equals("Walkin")) {
                    patients.add(p);
                }
            }
        }
        System.out.println(patients);
        return patients;
    }

    //Upload Reports
    public String saveFile(MultipartFile report, Long phone, String name) throws IOException {
        PatientRecords reports = new PatientRecords();
        System.out.println(phone);
        System.out.println(name);
        for(PatientRecords p : patientRecorRepo.findAll()) {
            if(p.getPhone_Number().equals(phone) && p.getPatient_First_Name().equals(name)) {
                p.setReportsPdf(report.getBytes());
                p.setFileName(reports.getFileName());
                patientRecorRepo.save(p);
                return "Success";
            }
        }
        return "Patient Not Found";
    }

}