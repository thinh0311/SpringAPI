package com.example.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.LoaiNuocEntity;

@Repository
public interface LoaiNuocReposity extends JpaRepository<LoaiNuocEntity, Long> {}