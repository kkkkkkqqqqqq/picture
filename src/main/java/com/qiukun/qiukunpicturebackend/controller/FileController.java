package com.qiukun.qiukunpicturebackend.controller;

import com.qiukun.qiukunpicturebackend.annotation.AuthCheck;
import com.qiukun.qiukunpicturebackend.common.BaseResponse;
import com.qiukun.qiukunpicturebackend.common.ResultUtils;
import com.qiukun.qiukunpicturebackend.constant.UserConstant;
import com.qiukun.qiukunpicturebackend.exception.BusinessException;
import com.qiukun.qiukunpicturebackend.exception.ErrorCode;
import com.qiukun.qiukunpicturebackend.manager.CosManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class FileController {

    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private CosManager cosManager;

    /**
     * 测试文件上传
     *
     * @param multipartFile
     * @return
     */
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    @PostMapping("/test/upload")
    public BaseResponse<String> testUploadFile(@RequestPart("file") MultipartFile multipartFile) {
        // 文件目录
        String filename = multipartFile.getOriginalFilename();
        String filepath = String.format("/test/%s", filename);
        File file = null;
        try {
            // 上传文件
            file = File.createTempFile(filepath, null);
            multipartFile.transferTo(file);
            cosManager.putObject(filepath, file);
            // 返回可访问地址
            return ResultUtils.success(filepath);
        } catch (Exception e) {
            log.error("file upload error, filepath = " + filepath, e);
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "上传失败");
        } finally {
            if (file != null) {
                // 删除临时文件
                boolean delete = file.delete();
                if (!delete) {
                    log.error("file delete error, filepath = {}", filepath);
                }
            }
        }
    }


}
