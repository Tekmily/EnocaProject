package com.enoca.enocap.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EPResponse {//clinet ekranına dönecek mesajları dinamik şekilde kullanmamızı sağlar
    private String message;
    boolean success;
}
