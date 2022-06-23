package com.lz.pretty.common.exception;

import com.lz.pretty.common.constant.CustomExceptionType;
import com.lz.pretty.common.domain.AjaxResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

/**
 * 类描述:
 * 全局异常处理
 *
 * @author lz
 * @create 2022-06-13 14:09
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public AjaxResponse customerException(CustomException e) {
        // 400异常不需要持久化，将异常信息以友好的方式告知用户就可以
        if (e.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            log.error("500服务异常" + e.getMessage());
            // TODO 将500异常信息持久化处理，方便运维人员处理
        }
        return AjaxResponse.error(e);
    }


    //处理程序员在程序中未能捕获（遗漏的）异常
    @ExceptionHandler(Exception.class)
    public AjaxResponse exception(Exception e) {
        log.error("程序异常" + e.getMessage());
        return AjaxResponse.error(new CustomException(CustomExceptionType.OTHER_ERROR));
    }

    // @RequestBody上使用@Valid 实体上使用@NotNull等，验证失败后抛出的异常是MethodArgumentNotValidException异常
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public AjaxResponse validException(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining());
        return AjaxResponse.error(CustomExceptionType.USER_INPUT_ERROR, message);
    }
}
