package com.myproj.jwt.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FinalResponse {
    private String message;
    private boolean status=false;
    private Object data;
}
