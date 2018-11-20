package com.yingu.project.big.data.exception;

/**
 * @author huangkunhao
 * @date 2018/11/20
 * @Description
 */
public class BigDataBaseException extends RuntimeException{

    public BigDataBaseException() {
    }

    public BigDataBaseException(String message) {
        super(message);
    }

    public BigDataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BigDataBaseException(Throwable cause) {
        super(cause);
    }

    public BigDataBaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
