package com.rick.webcoursedesign2022backend.result;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ResultVO {
    private String status_code;
    private String message;
    private Map<String,Object> map = new HashMap<>();
}
