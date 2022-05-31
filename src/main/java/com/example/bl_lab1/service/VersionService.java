package com.example.bl_lab1.service;

import com.example.bl_lab1.dto.VersionDto;
import com.example.bl_lab1.model.SectionEntity;
import com.example.bl_lab1.model.VersionEntity;

import java.util.List;
import java.util.Map;

public interface VersionService {
    void saveChangesByAuthorizedUser(String newText, String username, SectionEntity section);
    void saveChangesByUnauthorizedUser(String newText, SectionEntity section);
    void saveChanges(Map<String, Object> message) throws Exception;
    List<VersionEntity> getListOfWaitingUpdates();
    String getTextOfLastUpdateBySection(SectionEntity section);
    String getTextOfLastApprovedVersion(SectionEntity section);
    void approve(Integer id);
    void decline(Integer id);
}
