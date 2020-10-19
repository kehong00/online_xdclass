package cn.codewoo.shiro;

import cn.codewoo.constant.Constants;
import cn.codewoo.exception.BusinessException;
import cn.codewoo.utils.BaseRespCodeImpl;
import cn.codewoo.utils.DataResult;
import com.alibaba.fastjson.JSON;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author kehong
 */
public class CustomAccessControlFilter extends AccessControlFilter {
    Logger logger = LoggerFactory.getLogger(CustomAccessControlFilter.class);
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        try{
            HttpServletRequest request = (HttpServletRequest) servletRequest;
            String token = request.getHeader(Constants.AUTHENTICATED_TOKEN.toString());
            CustomToken customToken = new CustomToken(token);
            if (token == null || token.isEmpty()){
                throw new BusinessException(BaseRespCodeImpl.NOT_LOGIN);
            }
            Subject subject = this.getSubject(servletRequest, servletResponse);
            subject.login(customToken);
        }catch (BusinessException e){
            logger.error("发生自定义异常：" + e.getMsg(),e);
            customResponse(servletRequest,servletResponse,DataResult.getDataResult(e.getCode(),e.getMsg()));
            return false;
        }catch (AuthenticationException e){
            if (e.getCause() instanceof BusinessException){
                BusinessException businessException = (BusinessException) e.getCause();
                logger.error("发生认证异常：" + businessException.getMsg(),businessException);
                customResponse(servletRequest,servletResponse,DataResult.getDataResult(businessException.getCode(),businessException.getMsg()));
                return false;
            }
            logger.error("发生认证异常：" + e);
            customResponse(servletRequest,servletResponse,DataResult.getDataResult(BaseRespCodeImpl.AUTHENTICATED_ERROR));
            return false;
        }catch (Exception e){
            logger.error("发生系统异常：", e);
            customResponse(servletRequest,servletResponse, DataResult.getDataResult(BaseRespCodeImpl.SYS_ERROR));
            return false;
        }
        return true;
    }

    private void customResponse(ServletRequest request, ServletResponse response, DataResult result){
        try {
            response.setCharacterEncoding("utf8");
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            ServletOutputStream output = response.getOutputStream();
            String resultJson = JSON.toJSONString(result);
            output.write(resultJson.getBytes("utf8"));
            output.flush();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("发生系统异常：", e);
        }
    }
}
