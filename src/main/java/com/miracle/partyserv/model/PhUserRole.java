package com.miracle.partyserv.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ph_role")
public class PhUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private PhRoleType roleType;

    public PhUserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(PhRoleType roleType) {
        this.roleType = roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhUserRole that = (PhUserRole) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
