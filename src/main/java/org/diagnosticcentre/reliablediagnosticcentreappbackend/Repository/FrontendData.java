package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.FrontendPatientData;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientDetailsAndRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrontendData extends JpaRepository<FrontendPatientData, Integer> {
}
