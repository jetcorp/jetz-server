package jetz.server.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ResponseDto <T> {
    private Integer resultcode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorcode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errordescription;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;
}
