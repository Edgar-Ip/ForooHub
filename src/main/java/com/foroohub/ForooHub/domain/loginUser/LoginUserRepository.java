package com.foroohub.ForooHub.domain.loginUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface LoginUserRepository extends JpaRepository<LoginUser, Long> {
    UserDetails findByLogin(String username);
}

