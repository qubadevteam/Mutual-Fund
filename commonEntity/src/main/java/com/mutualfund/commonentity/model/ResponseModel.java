package com.mutualfund.commonentity.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseModel {

    private int code;
    private String status;
    private Object data;
    private String message;
    private Object errors;

    private Long totalElements;
    private Integer pageNumber;
    private Integer pageSize;
    private Integer totalPages;
    private Integer currentPageTotalProduct;

    public static ResponseModel createResponse(HttpStatus httpStatus, String message,
                                               Object data, Object errors) {
        return ResponseModel.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .data(data)
                .message(message)
                .errors(errors)
                .build();
    }


    public static ResponseModel paginationResponse(HttpStatus httpStatus,
                                                   String message, Object data,
                                                   Object errors, Long totalElements,
                                                   Integer pageNumber, Integer pageSize,
                                                   Integer currentPageTotalProduct) {

        int totalPages = 0;
        if (totalElements != null && pageSize != null && pageSize > 0) {
            totalPages = (int) Math.ceil((double) totalElements / pageSize);
        }

        return ResponseModel.builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .data(data)
                .message(message)
                .errors(errors)
                .totalElements(totalElements)
                .pageNumber(pageNumber)
                .pageSize(pageSize)
                .totalPages(totalPages)
                .currentPageTotalProduct(currentPageTotalProduct)
                .build();
    }
}
