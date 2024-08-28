package com.example.nodemanagement.repository;

import com.example.nodemanagement.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface NodeRepository extends JpaRepository<Node, Long> {

    boolean existsByNodeId(String nodeId);

}
