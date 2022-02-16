package com.korozet.zet.dto;

import com.korozet.zet.entity.User;
import lombok.Data;

@Data
public class UserDTO extends User {
    Integer roleId;
}
