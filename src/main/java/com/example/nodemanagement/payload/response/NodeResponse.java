package com.example.nodemanagement.payload.response;

import com.example.nodemanagement.entity.ENodeType;
import lombok.Data;

@Data
public class NodeResponse {

    private Long id;
    private String nodeId;
    private String nodeName;
    private String description;
    private String memo;
    private ENodeType nodeType;
    private ParentNodeResponse parentNode;

}
