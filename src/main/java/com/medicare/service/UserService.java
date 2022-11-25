package com.medicare.service;

import com.medicare.entity.Role;
import com.medicare.dao.RoleDao;
import com.medicare.dao.UserDao;
import com.medicare.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Role for every new user registered!");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserEmail("admin@medicare.com");
        adminUser.setUserPassword(getEncodedPassword("admin"));
        adminUser.setUserFirstName("Deepak ");
        adminUser.setUserLastName("Singh");
        adminUser.setUserAddress("Nava Road");
        adminUser.setUserMobile("9999999999");
        adminUser.setUserCity("Jaipur");
        adminUser.setUserState("Rajasthan");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);
    }

    public User registerNewUser(User user) {
        User existUser = this.userDao.findByUserEmail(user.getUserEmail());
        if (existUser != null) {
            try {
                System.out.println("User is already exist!");
            } catch (Exception e) {
                e.getMessage();
            }

        } else {
            //user will be created here
            Role role = roleDao.findById("User").get();
            Set<Role> userRoles = new HashSet<>();
            userRoles.add(role);
            user.setRole(userRoles);
            user.setUserPassword(getEncodedPassword(user.getUserPassword()));
            existUser = this.userDao.save(user);
        }
        return existUser;
    }

    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public List<User> getAllUsers() {
        return (List<User>) userDao.findAll();
    }
}
