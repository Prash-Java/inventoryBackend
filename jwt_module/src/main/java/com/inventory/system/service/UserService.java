package com.inventory.system.service;

import com.inventory.system.dao.RoleDao;
import com.inventory.system.dao.UserDao;
import com.inventory.system.entity.Role;
import com.inventory.system.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user) {
        return userDao.save(user);
    }

    public void initRolesAndUsers() {
        // Add 1st Role
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        roleDao.save(adminRole);

        // Add 2nd Role
        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default Role");
        roleDao.save(userRole);

        // Add 1st User
        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        // Add 2nd User
        User user = new User();
        user.setUserName("user123");
        user.setUserFirstName("user");
        user.setUserLastName("user");
        user.setUserPassword("user@pass");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }
}
