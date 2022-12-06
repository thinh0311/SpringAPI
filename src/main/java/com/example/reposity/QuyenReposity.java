package com.example.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.QuyenEntity;

@Repository
public interface QuyenReposity extends JpaRepository<QuyenEntity, Long> {}