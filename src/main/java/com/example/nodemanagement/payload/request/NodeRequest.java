package com.example.nodemanagement.payload.request;

import com.example.nodemanagement.entity.ENodeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class NodeRequest {

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Special characters are not allowed in nodeId")
    private String nodeId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "Special characters are not allowed in nodeName")
    private String nodeName;

    private String description;

    private String memo;

    @NotNull
    private ENodeType nodeType;

    @NotNull
    private String parentNodeGroupId;



}
