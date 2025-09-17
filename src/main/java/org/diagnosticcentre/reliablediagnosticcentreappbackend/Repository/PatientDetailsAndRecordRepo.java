package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientDetailsAndRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDetailsAndRecordRepo extends JpaRepository<PatientDetailsAndRecords,Integer> {
}
