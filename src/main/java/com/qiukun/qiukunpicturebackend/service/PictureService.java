package com.qiukun.qiukunpicturebackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiukun.qiukunpicturebackend.entity.Picture;
import com.baomidou.mybatisplus.extension.service.IService;
import com.qiukun.qiukunpicturebackend.entity.User;
import com.qiukun.qiukunpicturebackend.model.dto.picture.PictureQueryRequest;
import com.qiukun.qiukunpicturebackend.model.dto.picture.PictureUploadRequest;
import com.qiukun.qiukunpicturebackend.model.vo.PictureVO;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
* @author yzk10
* @description 针对表【picture(图片)】的数据库操作Service
* @createDate 2025-12-01 16:29:06
*/
public interface PictureService extends IService<Picture> {

    /**
     * 上传图片
     *
     * @param multipartFile
     * @param pictureUploadRequest
     * @param loginUser
     * @return
     */
    PictureVO uploadPicture(MultipartFile multipartFile,
                            PictureUploadRequest pictureUploadRequest,
                            User loginUser);

    /**
     * 构建图片查询条件
     *
     * @param pictureQueryRequest
     * @return
     */
    QueryWrapper<Picture> getQueryWrapper(PictureQueryRequest pictureQueryRequest);

    /**
     * 获取单个图片分装
     *
     * @param picture，request
     * @return
     */
    PictureVO getPictureVO(Picture picture, HttpServletRequest request);

    /**
     * 分页获取图片封装
     *
     * @param picturePage，request
     * @return
     */
    Page<PictureVO> getPictureVOPage(Page<Picture> picturePage, HttpServletRequest request);

    /**
     * 校验图片
     *
     * @param picture
     */
    void validPicture(Picture picture);
}
