package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;
import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.AppoinmentRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppoinmentRepo extends JpaRepository<AppoinmentRecords,Integer> {
}
