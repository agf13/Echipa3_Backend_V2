package com.echipa3.backend.security;

import com.echipa3.backend.entities.ApplicationUser;
import com.echipa3.backend.entities.Privilege;
import com.echipa3.backend.entities.Role;
import com.echipa3.backend.repositories.IRepoPrivilege;
import com.echipa3.backend.repositories.IRepoRole;
import com.echipa3.backend.repositories.IRepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class SetupDataLoader implements
        ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = false;

    @Autowired
    private IRepoUser userRepository;

    @Autowired
    private IRepoRole roleRepository;

    @Autowired
    private IRepoPrivilege privilegeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup)
            return;
        Privilege adminPrivilege
                = createPrivilegeIfNotFound("ADMIN_PRIVILEGE");
        Privilege userPrivilege
                = createPrivilegeIfNotFound("USER_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                adminPrivilege, userPrivilege);
        createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
        createRoleIfNotFound("ROLE_USER", Arrays.asList(adminPrivilege));

        Role adminRole = roleRepository.findByRole("ROLE_ADMIN");
        ApplicationUser user = new ApplicationUser();
        user.setUsername("admin");
        user.setPassword(passwordEncoder.encode("admin"));
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByPrivilege(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByRole(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
