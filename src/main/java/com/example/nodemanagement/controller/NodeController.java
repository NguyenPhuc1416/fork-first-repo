package com.example.nodemanagement.controller;

import com.example.nodemanagement.payload.request.NodeRequest;
import com.example.nodemanagement.payload.response.NodeResponse;
import com.example.nodemanagement.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
@RequestMapping("/api/nodes")
public class NodeController {


    private final NodeService nodeService;

    //    Constructor Injection which is considered as a best practice
    @Autowired
    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @PostMapping
    public ResponseEntity<NodeResponse> createNode(@RequestBody NodeRequest nodeRequest) {
        NodeResponse createdNode = nodeService.createNode(nodeRequest);
        return ResponseEntity.ok(createdNode);
    }

    @GetMapping
    public ResponseEntity<List<NodeResponse>> getNodes(Pageable pageable) {
        List<NodeResponse> nodes = nodeService.getNodes(pageable);
        return ResponseEntity.ok(nodes);
    }


}
