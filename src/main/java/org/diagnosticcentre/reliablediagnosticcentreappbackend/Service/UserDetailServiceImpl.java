package org.diagnosticcentre.reliablediagnosticcentreappbackend.Service;

import org.diagnosticcentre.reliablediagnosticcentreappbackend.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Autowired
    private PatientDetailsRepo patientDetailsRepo;

    @Autowired
    private ReceptionRepo receptionRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CommonUserDetails user;

        if ((user = adminRepo.findByUsername(username)) != null) return user;
        if ((user = doctorRepo.findByUsername(username)) != null) return user;
        if ((user = receptionRepo.findByUsername(username)) != null) return user;
        if ((user = patientDetailsRepo.findByUsername(username)) != null) return user;

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}
