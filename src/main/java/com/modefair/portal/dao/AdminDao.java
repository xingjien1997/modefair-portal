package com.modefair.portal.dao;

import com.modefair.portal.domain.Admin;

import java.util.Optional;

public interface AdminDao {
    Optional<Admin> getByAdminName(String adminName);
}
