package com.trustproject.core.services;

import com.trustproject.core.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User getUser(Long id);
}
