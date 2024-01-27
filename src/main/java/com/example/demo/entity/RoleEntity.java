package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RoleEntity {
private Integer id;
private String name;
private String description;
private String created_at;
private String update_at;
}
