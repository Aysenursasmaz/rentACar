package com.tobeto.pair9.services.dtos.user.requests;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChangePasswordRequest {

    private String email;
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;

}
