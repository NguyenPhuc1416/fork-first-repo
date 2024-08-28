package com.example.nodemanagement.repository;

import com.example.nodemanagement.entity.ParentNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentNodeRepository extends JpaRepository<ParentNode,Long> {
    Optional<ParentNode> findByParentNodeGroupId(String parentNodeGroupId);

}
