package com.vipul.Vipul.pos.system.repository;

import com.vipul.Vipul.pos.system.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    List<CategoryEntity> findByProfileId(Long profileId);

    Optional<CategoryEntity>findByIdAndProfileId(Long id ,Long profileId);
    
    List<CategoryEntity> findByTypeAndProfileId(String type,Long profileId);


}
