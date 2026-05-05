package lk.icptechnologies.carergo.campusbackend.entity;

import jakarta.persistence.Entity;

@Entity
public class AdminUser extends User {

    public AdminUser() {
        super();
    }

    public AdminUser(String username, String email, String password, String membershipType) {
        super(username, email, password, membershipType);
    }

    @Override
    public String getRoleDetails() {
        return "Administrator Role with full privileges";
    }
}
