# Node Management Application

## Overview
The Node Management Application is a Spring Boot microservice designed to manage nodes.

## Features

- **Create Node**: Add new nodes with validation to ensure data integrity.
- **Get Nodes**: Retrieve a list of nodes with optional pagination support.
- **Parent Node Management**: Each node is associated with a parent node.

## Sample Data

![data](https://github.com/user-attachments/assets/fcfee5db-08f8-478d-8596-08bd46866e60)

## Schema

```agsl
-- Schema for parent_nodes table
CREATE TABLE parent_nodes (
    id SERIAL PRIMARY KEY,
    parent_node_group_id VARCHAR(50) NOT NULL UNIQUE,
    parent_node_name VARCHAR(100) NOT NULL,
    parent_node_group_name VARCHAR(50) NOT NULL
);

-- Schema for nodes table
CREATE TABLE nodes (
    id SERIAL PRIMARY KEY,
    node_id VARCHAR(50) NOT NULL UNIQUE,
    node_name VARCHAR(100) NOT NULL,
    description TEXT,
    memo TEXT,
    node_type VARCHAR(50),
    parent_node_group_id VARCHAR(50),
    FOREIGN KEY (parent_node_group_id) REFERENCES parent_nodes(parent_node_group_id)
);

```
To populate the `parent_nodes` table with some initial data, you can use the following SQL query:

```sql
INSERT INTO parent_nodes (parent_node_group_id, parent_node_name, parent_node_group_name)
VALUES
('PARENT_001', 'Parent Node 1', 'SUBGROUP_NE_1'),
('PARENT_002', 'Parent Node 2', 'SUBGROUP_NE_2'),
('PARENT_003', 'Parent Node 3', 'GROUP_1'),
('PARENT_004', 'Parent Node 4', 'GROUP_1'),
('PARENT_005', 'Parent Node 5', 'SUBGROUP_NE_1');
```

## API Testing
**Post Request** : `http://localhost:8096/api/nodes`
```json
{
    "node_id": "NODE_001",
    "node_name": "Node 1",
    "description": "Node 1 Description",
    "memo": "Node 1 Memo",
    "node_type": "TYPE_1",
    "parent_node_group_id": "PARENT_001"
}
```
![Post_Request](https://github.com/user-attachments/assets/5262d32f-1e4f-49b6-ab86-b1fb7b0d1985)

**Get Request** : `http://localhost:8096/api/nodes`

**Get Request with Pagination** : `http://localhost:8096/api/nodes?page=0&size=2`

![Get_Request](https://github.com/user-attachments/assets/ddc0d38f-42bb-4f39-8c7a-e5b4ab9a6475)

