package com.example.demo.repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.File;
import com.example.demo.model.Tag;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
  @Query(value = "SELECT DISTINCT f.* FROM File f JOIN file_tag ft ON f.id = ft.file_id JOIN tag t ON ft.tag_id = t.tag_id JOIN Users u ON f.user_id = u.id WHERE (t.tag_name LIKE %?1% OR f.file_name LIKE %?1% OR u.name LIKE %?1%) GROUP BY f.id ORDER BY COUNT(DISTINCT t.tag_name) DESC, f.file_name LIKE %?1% DESC, u.name LIKE %?1% DESC", nativeQuery = true)
  List<File> search(String keyword);

  List<File> findByCategoryId(Long status);

  Optional<File> findById(Long id);

  @Query(value = "SELECT * FROM file ORDER BY view DESC LIMIT 3", nativeQuery = true)
  List<File> listTopFile();

  @Query(value = "SELECT * FROM file ORDER BY like_file DESC LIMIT 7", nativeQuery = true)
  List<File> listViewsFile();

  @Query("SELECT SUM(f.view) FROM File f")
  Double sumView();

  // List<File> findByTagsIn(Set<Tag> tags, Pageable pageable);
  @Query("SELECT f FROM File f JOIN f.tags t WHERE t IN :tags GROUP BY f.id ORDER BY COUNT(t) DESC")
  List<File> findByTagsIn(@Param("tags") Set<Tag> tags, Pageable pageable);

  @Query("SELECT f FROM File f WHERE f.category.id = :categoryId")
  List<File> findFilesByCategoryId(@Param("categoryId") Long categoryId, Pageable pageable);

  @Query("SELECT COUNT(f.id) FROM File f")
  Long getTotalFilesForSystem();
}
