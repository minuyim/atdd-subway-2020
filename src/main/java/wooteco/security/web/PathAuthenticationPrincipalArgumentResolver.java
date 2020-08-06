package wooteco.security.web;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import wooteco.security.core.Authentication;
import wooteco.security.core.PathAuthenticationPrincipal;
import wooteco.security.core.context.SecurityContextHolder;
import wooteco.subway.members.member.domain.LoginMember;

import java.util.Map;

public class PathAuthenticationPrincipalArgumentResolver extends AuthenticationPrincipalArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(PathAuthenticationPrincipal.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return new LoginMember(null, null, null, null);
        }
        if (authentication.getPrincipal() instanceof Map) {
            return extractPrincipal(parameter, authentication);
        }

        return authentication.getPrincipal();
    }
}
