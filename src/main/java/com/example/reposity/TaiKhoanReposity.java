package com.example.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TaiKhoanEntity;

@Repository
public interface TaiKhoanReposity extends JpaRepository<TaiKhoanEntity, Long> {}