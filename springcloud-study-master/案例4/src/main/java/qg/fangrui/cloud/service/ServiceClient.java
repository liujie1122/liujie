package qg.fangrui.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import qg.fangrui.cloud.hystrix.ServiceClientHystrix;

/**
 * //@FeignClient 绑定服务
 * Created by zggdczfr on 2017/2/18.
 */
@Component
@FeignClient(value = "my-service", fallback = ServiceClientHystrix.class)
public interface ServiceClient {

    @RequestMapping("/service")
    String printf();
}
