package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailsRepo extends JpaRepository<PatientDetails,Integer> {
    PatientDetails findByUsername(String username);
}
