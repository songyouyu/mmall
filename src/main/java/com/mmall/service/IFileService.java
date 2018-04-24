package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by songy on 2018/1/2.
 */
public interface IFileService {

    //上传文件
    String upload(MultipartFile file, String path);

}
