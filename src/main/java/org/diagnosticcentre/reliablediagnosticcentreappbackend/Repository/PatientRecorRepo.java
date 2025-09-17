package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.PatientRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRecorRepo extends JpaRepository<PatientRecords,Integer> {
}
