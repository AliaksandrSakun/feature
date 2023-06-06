package com.trustproject.core.facades;

import com.trustproject.core.dto.UserDTO;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserFacade {
    UserDTO getUserById(@PathVariable Long id);
}
