package com.modefair.portal.service;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Map<String, List<String>> findAllMapWithLecturerAndCourses();
    boolean authenticate(String username, String password) throws Exception;
}
