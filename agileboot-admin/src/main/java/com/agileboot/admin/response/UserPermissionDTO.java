package com.agileboot.admin.response;

import com.agileboot.domain.system.user.dto.UserDTO;
import java.util.Map;
import java.util.Set;
import lombok.Data;

/**
 * @author valarchie
 */
@Data
public class UserPermissionDTO {

    private UserDTO user;
    private String roleKey;
    private Set<String> permissions;
    private Map dictTypes;

}
