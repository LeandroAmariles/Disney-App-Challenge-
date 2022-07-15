package security.entities;

import security.enums.RoleList;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RoleList roleName;

    public Role(){

    }

    public Role( @NotNull  RoleList roleName) {
        this.roleName = roleName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleList getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleList roleName) {
        this.roleName = roleName;
    }
}
