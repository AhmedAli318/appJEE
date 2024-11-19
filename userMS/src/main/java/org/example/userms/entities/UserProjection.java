package org.example.userms.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = User.class,name = "proj1")
public interface UserProjection {
    public Long getId();
    public String getFirstName();
    public String getLastName();
}
