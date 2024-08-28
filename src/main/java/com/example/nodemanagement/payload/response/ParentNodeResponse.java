package com.example.nodemanagement.payload.response;

import com.example.nodemanagement.entity.EParentNodeGroupName;
import lombok.Data;

@Data
public class ParentNodeResponse {
    private String parentNodeGroupId;
    private String parentNodeName;
    private EParentNodeGroupName parentNodeGroupName;

}
