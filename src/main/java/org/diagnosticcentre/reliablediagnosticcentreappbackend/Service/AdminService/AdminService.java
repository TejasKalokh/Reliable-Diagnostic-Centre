package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.AdminService;

import org.aspectj.weaver.ast.Test;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.DoctorDetails;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientDetails;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.ReceptionDetails;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.TestDetails;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.DoctorRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.PatientDetailsRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.ReceptionRepo;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminService {
//
    @Autowired
    private TestRepo testRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private ReceptionRepo receptionRepo;

    @Autowired
    private PatientDetailsRepo patientDetailsRepo;

    //ALL TEST
    public List<TestDetails> getAllTests() {
        List<TestDetails> tests = new ArrayList<>();
        for(TestDetails t : testRepo.findAll()){
            tests.add(t);
        }
        return tests;
    }

    //ALL DOCTOR
    public List<DoctorDetails> getAllDoctors() {
        List<DoctorDetails> doctors = new ArrayList<>();
        for(DoctorDetails d : doctorRepo.findAll()){
            doctors.add(d);
        }
        return doctors;
    }

    //ALL RECEPTION
    public List<ReceptionDetails> getAllReceptions() {
        List<ReceptionDetails> receptions = new ArrayList<>();
        for(ReceptionDetails r : receptionRepo.findAll()){
            receptions.add(r);
        }
        return receptions;
    }

    //Add Test
    public String AddTest(TestDetails test) {
        testRepo.save(test);
        return test.toString();
    }

    //Remove Test
//    public String RemoveTest(TestDetails test) {
////        for(TestDetails t : testRepo.findAll()){
////            if(test.equals(t)){
////                testRepo.delete(t);
////            }
////        }
//        testRepo.deleteAllById(t);
//        return test.toString() + "Test removed";
//    }

    //Update Pricing
    public String UpdateCharges(TestDetails test) {
    for(TestDetails t : testRepo.findAll()){
        if(test.getTestname().equals(t.getTestname())){
            t.setTestcharge(test.getTestcharge());
        }
    }
    return test.toString()+"Charges Updated";
    }

    //Remove Reception
    public String RemoveReception(ReceptionDetails r) {
    receptionRepo.delete(r);
    return r.toString();
    }

    //Remove Doctor
    public String RemoveDoctor(DoctorDetails d) {
    doctorRepo.delete(d);
    return d.toString();
    }



}
