package com.example.nodemanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Entity
@Data
@Table(name = "nodes")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_]*$", message = "Special characters are not allowed in nodeId")
    @Column(name = "node_id", nullable = false, unique = true)
    private String nodeId;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "Special characters are not allowed in nodeName")
    @Column(name = "node_name", nullable = false)
    private String nodeName;

    private String description;

    private String memo;

    @Enumerated(EnumType.STRING)
    private ENodeType nodeType;

    @ManyToOne
    @JoinColumn(name = "parent_node_group_id",referencedColumnName = "parent_node_group_id")
    private  ParentNode parentNode;

}
