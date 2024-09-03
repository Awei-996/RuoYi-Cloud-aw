package com.ruoyi.system.api;

import com.ruoyi.common.core.constant.SecurityConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.system.api.domain.SysFile;
import com.ruoyi.system.api.factory.RemoteFileFallbackFactory;

/**
 * 文件服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remoteFileService", value = "${feign.name}", fallbackFactory = RemoteFileFallbackFactory.class,configuration = RemoteFileConfiguration.class)
public interface RemoteFileService extends BaseFeignClient<SysFile>
{
    /**
     * 上传文件
     *
     * @param file 文件信息
     * @return 结果
     */
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public R<SysFile> upload(@RequestPart(value = "file") MultipartFile file);


    /** 测试feign内部调用
     * @param name
     * @param source
     * @return
     */
    @GetMapping("t1/{name}")
    public String t1(@PathVariable("name") String name,@RequestHeader(SecurityConstants.FROM_SOURCE) String source);
}
