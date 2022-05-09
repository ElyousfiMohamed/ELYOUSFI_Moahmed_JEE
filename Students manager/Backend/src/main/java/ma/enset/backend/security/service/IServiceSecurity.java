package ma.enset.backend.security.service;

import ma.enset.backend.security.entities.AppRole;
import ma.enset.backend.security.entities.AppUser;

public interface IServiceSecurity {
    AppUser saveNewUser(String username, String password, String verifyPassword);
    AppRole saveNewRole(String rolename, String Desciption);

    void addRoleToUser(String username,String rolename);
    void delRoleFromUser(String username,String rolename);

    AppUser loadByUserName(String username);
    AppRole loadByRoleName(String rolename);
}
