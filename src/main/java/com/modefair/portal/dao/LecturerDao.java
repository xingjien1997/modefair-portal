package com.modefair.portal.dao;

import com.modefair.portal.domain.Lecturer;

import java.util.List;

public interface LecturerDao {
    List<Lecturer> findAll();

    Lecturer getLecturerByName(String name);
}
