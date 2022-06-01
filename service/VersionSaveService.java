package com.example.bl_lab1.service;



import java.util.Map;

public interface VersionSaveService {
    void saveChanges(Map<String, Object> message) throws Exception;
//    void saveChangesByUnauthorizedUser(String newText, String ip, SectionEntity section) throws Exception;
}
