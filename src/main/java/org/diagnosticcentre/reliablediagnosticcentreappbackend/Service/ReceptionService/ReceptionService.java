package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.ReceptionService;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.*;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Service
public class ReceptionService {
    @Autowired
    private PatientRecorRepo patientRecorRepo;

    @Autowired
    private AppoinmentRepo appoinmentRepo;

    @Autowired
    private PatientDetailsRepo patientDetailsRepo;

    @Autowired
    private PatientDetailsAndRecordRepo patientDetailsAndRecordRepo;

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private UPIService upiService;

    @Autowired
    private QRCodeService qrCodeService;

    @Autowired
    private TestRepo testRepoTest;


    public String setPatientdetais(PatientDetailsAndRecords patientDetailsAndRecords) {
        PatientDetails p = new PatientDetails();
        p.setAddress(patientDetailsAndRecords.getAddress());
        p.setAge(patientDetailsAndRecords.getAge());
        p.setGender(patientDetailsAndRecords.getGender());
        p.setPatient_First_Name(patientDetailsAndRecords.getPatient_First_Name());
        p.setPatient_Last_Name(patientDetailsAndRecords.getPatient_Last_Name());
        p.setPatient_Middle_Name(patientDetailsAndRecords.getPatient_Middle_Name());
        p.setPhone_Number(patientDetailsAndRecords.getPhone_Number());
        p.setLocality(patientDetailsAndRecords.getLocality());
        p.setPatient_Id(patientDetailsAndRecords.getPatient_Id());
        p.setPassword(String.valueOf(p.getPatient_Id()));
        p.setUsername(Integer.parseInt(patientDetailsAndRecords.getUsername()));
        patientDetailsRepo.save(p);
        return "Success";
    }


    public String setPatientrecord(PatientDetailsAndRecords patientDetailsAndRecords) {
        PatientRecords p = new PatientRecords();
        p.setAge(patientDetailsAndRecords.getAge());
        p.setGender(patientDetailsAndRecords.getGender());
        p.setPatient_First_Name(patientDetailsAndRecords.getPatient_First_Name());
        p.setPatient_Last_Name(patientDetailsAndRecords.getPatient_Last_Name());
        p.setPatient_Middle_Name(patientDetailsAndRecords.getPatient_Middle_Name());
        p.setPhone_Number(patientDetailsAndRecords.getPhone_Number());
        p.setPatient_Id(patientDetailsAndRecords.getPatient_Id());
        p.setImageName(patientDetailsAndRecords.getImageName);
        p.setPrescription_Image_Data(patientDetailsAndRecords.getPrescription_Image_Data());
        p.setTest_Date(patientDetailsAndRecords.getTest_Date());
        p.setTest_Time(patientDetailsAndRecords.getTest_Time());
        p.setTest_Type(patientDetailsAndRecords.getTest_Type());
        p.setTest_Date(patientDetailsAndRecords.getTest_Date());
        p.setTest_Time(patientDetailsAndRecords.getTest_Time());
        p.setVist_Type(patientDetailsAndRecords.getVist_Type());
        patientRecorRepo.save(p);
        return "Success";
    }

    public void setAppoinment(PatientDetailsAndRecords patientDetailsAndRecords) {
        AppoinmentRecords a = new AppoinmentRecords();
        a.setAge(patientDetailsAndRecords.getAge());
        a.setGender(patientDetailsAndRecords.getGender());
        a.setPatient_First_Name(patientDetailsAndRecords.getPatient_First_Name());
        a.setPatient_Last_Name(patientDetailsAndRecords.getPatient_Last_Name());
        a.setPhone_Number(patientDetailsAndRecords.getPhone_Number());
        a.setPatient_Middle_Name(patientDetailsAndRecords.getPatient_Middle_Name());
        a.setPatient_Id(patientDetailsAndRecords.getPatient_Id());
        a.setTest_Date(patientDetailsAndRecords.getTest_Date());
        a.setTest_Time(patientDetailsAndRecords.getTest_Time());
        a.setTest_Type(patientDetailsAndRecords.getTest_Type());
        appoinmentRepo.save(a);
    }

    public List<PatientDetailsAndRecords> AddPatient(PatientDetailsAndRecords patientDetailsAndRecords) {
        if (patientDetailsAndRecords.getTest_Date() == null) {
            patientDetailsAndRecords.setTest_Date(LocalDate.now());
        }
//        if (patientDetailsAndRecords.getTest_Time() == null) {
//            patientDetailsAndRecords.setTest_Time(LocalTime.now());
//        }
        if (patientDetailsAndRecords.getTest_Time() == null) {
            LocalTime now = LocalTime.now().withSecond(0).withNano(0);
            patientDetailsAndRecords.setTest_Time(now);
        }

        if (patientDetailsAndRecords.getTest_Date().equals(LocalDate.now()) &&
                patientDetailsAndRecords.getTest_Time().equals(LocalTime.now())) {
            patientDetailsAndRecords.setVist_Type("Walkin");
        } else {
            patientDetailsAndRecords.setVist_Type("Appoinment");
        }
        int currentserial = (int) (patientDetailsRepo.count() + 1);
        int currentdate = LocalDate.now().getDayOfMonth();
        int currentmonth = LocalDate.now().getMonthValue();
        int currentyear = LocalDate.now().getYear();
        String dateString = String.format("%04d%02d%02d%d", currentserial, currentdate, currentmonth, currentyear);
        Long Patient_Id = Long.parseLong(dateString);
        patientDetailsAndRecords.setPatient_Id(Patient_Id);
        patientDetailsAndRecords.setPassword(String.valueOf(Patient_Id));
        patientDetailsAndRecords.setUsername(String.valueOf(Patient_Id));
        patientDetailsAndRecordRepo.save(patientDetailsAndRecords);
        if (!Objects.equals(patientDetailsAndRecords.getTest_Date(), LocalDate.now()) && !Objects.equals(patientDetailsAndRecords.getTest_Time(),(LocalTime.now()))) {
            setAppoinment(patientDetailsAndRecords);
        }
        setPatientdetais(patientDetailsAndRecords);
        setPatientrecord(patientDetailsAndRecords);
        return patientDetailsAndRecordRepo.findAll();
    }

    public List<TestDetails> getTestDetails(){
        List<TestDetails> tests = new ArrayList<>();
        for(TestDetails t : testRepo.findAll()){
            tests.add(t);
        }
        return tests;
    }

    public ResponseEntity<?> createPayment(@RequestBody TestDetails testname) {
        try {
            for(TestDetails t : testRepo.findAll()){
                if(t.getTestname().equals(testname.getTestname())){
                    testname.setTestcharge(t.getTestcharge());
                }
            }
            String message = String.format("Payment for Test: %s", testname.getTestname()).replace("+", " ");
            int charge = testname.getTestcharge();
            if(charge == 0){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Test not found");
            }
            String transactionId = UUID.randomUUID().toString();
            System.out.println(charge);
            String upiString = upiService.generateUPIString(
                    "kalokhetejas3@oksbi",
                    "Tejas",
                    "9372683895",
                    transactionId,
                    message,
                    charge,
                    "INR"
            );

            byte[] qrCodeImage = qrCodeService.generateQRCode(upiString, 250, 250);

            String base64Image = Base64.getEncoder().encodeToString(qrCodeImage);

            return ResponseEntity.ok(new PaymentResponse(transactionId, base64Image));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating payment: " + e.getMessage());
        }
    }

    public List<PatientRecords> getwalkinpatient() {
        List<PatientRecords> p = new ArrayList<>();
        for(PatientRecords p1 : patientRecorRepo.findAll()){
            if(p1.getVist_Type().equals("Walkin")){
                p.add(p1);
            }
        }
        return p;
    }

    public List<PatientRecords> getappoinmentpatient() {
        List<PatientRecords> p = new ArrayList<>();
        for(PatientRecords p1 : patientRecorRepo.findAll()){
            if(p1.getVist_Type().equals("Appoinment")){
                p.add(p1);
            }
        }
        return p;
    }


    record PaymentRequest(double amount) {
        public double getAmount() {
            return amount;
        }
    }
}
record PaymentResponse(String transactionId, String qrCodeBase64) {}