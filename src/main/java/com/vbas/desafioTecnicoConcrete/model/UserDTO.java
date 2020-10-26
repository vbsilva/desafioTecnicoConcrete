package com.vbas.desafioTecnicoConcrete.model;

import java.util.Date;
import java.util.UUID;

public class UserDTO {
    private UUID id;
    private Date created;
    private Date modified;
    private Date last_login;
    private String token;

    public UserDTO(User user) {
        this.id = user.getId();
        this.created = user.getCreated();
        this.modified = user.getModified();
        this.last_login = user.getLast_login();
        this.token = user.getToken();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
