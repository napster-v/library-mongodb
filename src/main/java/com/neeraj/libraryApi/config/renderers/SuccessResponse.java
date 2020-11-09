package com.neeraj.libraryApi.config.renderers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuccessResponse<T> {
    private T data;

    public SuccessResponse(T data) {
        this.data = data;
    }
}
