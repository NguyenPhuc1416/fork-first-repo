package com.example.nodemanagement.service.impl;

import com.example.nodemanagement.entity.Node;
import com.example.nodemanagement.entity.ParentNode;
import com.example.nodemanagement.exception.NodeAlreadyExistsException;
import com.example.nodemanagement.payload.request.NodeRequest;
import com.example.nodemanagement.payload.response.NodeResponse;
import com.example.nodemanagement.payload.response.ParentNodeResponse;
import com.example.nodemanagement.repository.NodeRepository;
import com.example.nodemanagement.repository.ParentNodeRepository;
import com.example.nodemanagement.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NodeServiceImpl implements NodeService {


    private final NodeRepository nodeRepository;
    private final ParentNodeRepository parentNodeRepository;

    @Autowired
    public NodeServiceImpl(NodeRepository nodeRepository, ParentNodeRepository parentNodeRepository) {
        this.nodeRepository = nodeRepository;
        this.parentNodeRepository = parentNodeRepository;
    }

    @Override
    public NodeResponse createNode(NodeRequest nodeRequest) {
        ParentNode parentNode = parentNodeRepository.findByParentNodeGroupId(nodeRequest.getParentNodeGroupId()).orElseThrow(() -> new IllegalArgumentException("Parent Node not found"));

        if(nodeRepository.existsByNodeId(nodeRequest.getNodeId())) {
            throw new NodeAlreadyExistsException("Node with id " + nodeRequest.getNodeId() + " already exists");
        }

        Node node = new Node();
        node.setNodeId(nodeRequest.getNodeId());
        node.setNodeName(nodeRequest.getNodeName());
        node.setDescription(nodeRequest.getDescription());
        node.setMemo(nodeRequest.getMemo());
        node.setNodeType(nodeRequest.getNodeType());
        node.setParentNode(parentNode);

        nodeRepository.save(node);
        return toNodeResponse(node);

    }

    @Override
    public List<NodeResponse> getNodes(Pageable pageable) {
        Page<Node> nodes = nodeRepository.findAll(pageable);
        return nodes.map(this::toNodeResponse).getContent();
    }

    private NodeResponse toNodeResponse(Node node) {
        NodeResponse nodeResponse = new NodeResponse();
        nodeResponse.setId(node.getId());
        nodeResponse.setNodeId(node.getNodeId());
        nodeResponse.setNodeName(node.getNodeName());
        nodeResponse.setDescription(node.getDescription());
        nodeResponse.setMemo(node.getMemo());
        nodeResponse.setNodeType(node.getNodeType());

        ParentNode parentNode = node.getParentNode();
        if (parentNode != null) {
            ParentNodeResponse parentNodeResponse = new ParentNodeResponse();
            parentNodeResponse.setParentNodeGroupId(parentNode.getParentNodeGroupId());
            parentNodeResponse.setParentNodeName(parentNode.getParentNodeName());
            parentNodeResponse.setParentNodeGroupName(parentNode.getParentNodeGroupName());
            nodeResponse.setParentNode(parentNodeResponse);
        }

        return nodeResponse;
    }
}
