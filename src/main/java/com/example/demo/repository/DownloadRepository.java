package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Download;

@Repository
public interface DownloadRepository extends JpaRepository<Download, Long> {
    @Query("SELECT COUNT(d.id) FROM Download d")
    Long getTotalDownloadsForSystem();
}