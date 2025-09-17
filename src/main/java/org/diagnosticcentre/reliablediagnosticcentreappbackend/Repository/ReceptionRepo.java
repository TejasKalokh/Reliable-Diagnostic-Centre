package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.ReceptionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionRepo extends JpaRepository<ReceptionDetails, Integer> {
    ReceptionDetails findByUsername(String username);
}
