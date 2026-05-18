package lk.icptechnologies.carergo.campusbackend.entity;

import jakarta.persistence.Entity;

@Entity
public class RegularUser extends User {

    public RegularUser() {
        super();
    }

    public RegularUser(String username, String email, String password, String membershipType) {
        super(username, email, password, membershipType);
    }

    @Override
    public String getRoleDetails() {
        return "Regular User Role with standard access";
    }
}
