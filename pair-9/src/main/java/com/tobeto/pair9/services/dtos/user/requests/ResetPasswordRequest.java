package com.tobeto.pair9.services.dtos.user.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ResetPasswordRequest {

    private String newPassword;
    private String confirmationPassword;

}
