package com.github.knightliao.disconf.web.support.exception;

import com.github.knightliao.disconf.web.support.exception.base.ErrorCode;
import com.github.knightliao.disconf.web.support.exception.base.ModuleCode;
import com.github.knightliao.disconf.web.support.exception.base.RuntimeGlobalException;

/**
 * 用于远程连接错误
 *
 * @author liaoqiqi
 * @version 2014-1-26
 */
public class RemoteException extends RuntimeGlobalException {

    private static final long serialVersionUID = 1L;

    public RemoteException(String exceptionMessage) {
        super(ErrorCode.REMOTE_ERROR, exceptionMessage);
    }

    @Override
    public ModuleCode getModuleCode() {
        return ModuleCode.REMOTE;
    }

    public RemoteException(String exceptionMessage, Throwable throwable) {

        super(ErrorCode.REMOTE_ERROR, exceptionMessage, throwable);
    }
}
