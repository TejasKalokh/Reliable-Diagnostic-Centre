package org.diagnosticcentre.reliablediagnosticcentreappbackend.Controller.AmdinCon;

import org.aspectj.weaver.ast.Test;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.TestDetails;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Service.AdminService.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "*")
public class AdminPanel {
    @Autowired
    AdminService adminService;

    @PostMapping("/addtest")
    public String addTest(@RequestBody TestDetails test) {
        adminService.AddTest(test);
        return test.toString();
    }

    @PutMapping("/updatetest")
    public String removeTest(@RequestBody TestDetails test) {
        adminService.UpdateCharges(test);
        return test.toString() + "Test Charges Updated";
    }



}
