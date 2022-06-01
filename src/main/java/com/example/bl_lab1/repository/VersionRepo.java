package com.example.bl_lab1.repository;

import com.example.bl_lab1.model.VersionEntity;
import org.springframework.data.repository.CrudRepository;

public interface VersionRepo  extends CrudRepository<VersionEntity, Integer> {
}
