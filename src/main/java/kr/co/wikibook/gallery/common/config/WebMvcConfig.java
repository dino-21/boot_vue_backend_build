package kr.co.wikibook.gallery.common.config;

import kr.co.wikibook.gallery.common.interceptor.ApiInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // ①
@RequiredArgsConstructor // ②
public class WebMvcConfig  implements WebMvcConfigurer {

    private final ApiInterceptor apiInterceptor; // ③

    @Override
    public void addInterceptors(InterceptorRegistry registry) { // ④
        registry.addInterceptor(apiInterceptor)
                .addPathPatterns("/v1/api/**")
                .excludePathPatterns("/v1/api/account/**", "/v1/api/items/**"); // 예외
    }
}
