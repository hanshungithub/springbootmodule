package cn.hassan.jwt.interceptors;

import cn.hassan.jwt.entity.TokenInfoEntity;
import cn.hassan.jwt.jpa.TokenJPA;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created with IntelliJ IDEA.
 * Author: hassan
 * Date: 2018/4/30 14:15
 * Description:
 */
@Slf4j
public class TokenInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getRequestURI().equals("/token") || RequestMethod.OPTIONS.toString().equals(request.getMethod())){
            return true;
        }
        String header = request.getHeader("X-YAuth-Token");
        try {
            if (header == null || header.trim() == "") {
                throw new SignatureException("not found X-YAuth-Token.");
            }
            Claims body = Jwts.parser().setSigningKey("HengYuAuthv1.0.0").parseClaimsJws(header).getBody();
            TokenInfoEntity infoEntity = getDao(TokenJPA.class, request).findOne(new Specification<TokenInfoEntity>() {
                @Override
                public Predicate toPredicate(Root<TokenInfoEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    criteriaQuery.where(criteriaBuilder.equal(root.get("appId"), body.getSubject()));
                    return null;
                }
            });
            String tokenVal = String.valueOf(infoEntity.getToken());
            if (tokenVal == null || tokenVal.trim() == "") {
                throw new Exception("not found token info, please get token agin.");
            }
            if (tokenVal.equals(header)) {
                throw new Exception("not found token info, please get token agin.");
            }
        } catch (Exception e) {
            //输出对象
            PrintWriter writer = response.getWriter();

            //输出error消息
            writer.write("need refresh token");
            writer.close();
            log.error("JWT拦截器解析出错" + e);
            return false;
        }
        return false;
    }

    private <T> T getDao(Class<T> clazz, HttpServletRequest request) {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
