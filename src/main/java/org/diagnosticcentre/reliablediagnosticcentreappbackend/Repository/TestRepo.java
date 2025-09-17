package org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Model.TestDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepo extends JpaRepository<TestDetails,Integer> {
}
