package com.example.nodemanagement.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name="parent_nodes")
public class ParentNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Special characters are not allowed in parentNodeGroupId")
    @Column(name = "parent_node_group_id", nullable = false, unique = true)
    private String parentNodeGroupId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "Special characters are not allowed in parentNodeName")
    private String parentNodeName;


    @Enumerated(EnumType.STRING)
    private EParentNodeGroupName parentNodeGroupName;

}
