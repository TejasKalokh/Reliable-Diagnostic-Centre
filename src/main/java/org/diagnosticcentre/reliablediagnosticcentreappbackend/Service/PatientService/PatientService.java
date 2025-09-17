package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.PatientService;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientDetailsAndRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientRecords;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.AppoinmentRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.PatientDetailsRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.PatientRecorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class PatientService {
    @Autowired
    private PatientDetailsRepo patientDetailsRepo;

    @Autowired
    private AppoinmentRepo appoinmentRepo;

    @Autowired
    private PatientRecorRepo patientRecorRepo;


    public List<PatientRecords> getReportsPdf(Long id) {
//        Long patientId = Long.parseLong(id);
        System.out.println("patient id form service " + id );
        List<PatientRecords> a = new ArrayList<PatientRecords>();
        for(PatientRecords p : patientRecorRepo.findAll()) {
            if(Objects.equals(p.getPatient_Id(), id)) {
                a.add(p);
            }
        }
        return a;
    }

}
