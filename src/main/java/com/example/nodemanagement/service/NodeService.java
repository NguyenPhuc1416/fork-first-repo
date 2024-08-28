package com.example.nodemanagement.service;

import com.example.nodemanagement.payload.request.NodeRequest;
import com.example.nodemanagement.payload.response.NodeResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NodeService {

    NodeResponse createNode(NodeRequest nodeRequest);

    List<NodeResponse> getNodes(Pageable pageable);


}
