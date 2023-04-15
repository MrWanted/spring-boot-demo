package com.example.springbootdemo.api.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public record ErrorResponse(int errorCode, String errorMessage) {
}
