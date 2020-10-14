package cn.codewoo.exception;

import cn.codewoo.utils.BaseRespCodeImpl;
import cn.codewoo.utils.DataResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kehong
 * 全局异常处理类
 */
@ControllerAdvice
public class CustomExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public DataResult handler(Exception e){
        logger.error("发生系统异常：",e );
        return DataResult.getDataResult(BaseRespCodeImpl.SYS_ERROR);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public DataResult handler(BusinessException e){
        logger.error("发生异常" + e.getMsg(),e);
        return DataResult.getDataResult(e.getCode(),e.getMsg());
    }
}
