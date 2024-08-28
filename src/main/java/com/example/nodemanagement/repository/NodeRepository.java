package com.example.nodemanagement.repository;

import com.example.nodemanagement.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {

    boolean existsByNodeId(String nodeId);

}
