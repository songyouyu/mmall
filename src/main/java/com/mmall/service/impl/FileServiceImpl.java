package com.mmall.service.impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by songy on 2018/1/2.
 */
@Service("iFileService")
public class FileServiceImpl implements IFileService{

    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    public String upload(MultipartFile file, String path) {
        //获得原始文件名
        String fileName = file.getOriginalFilename();
        //扩展名
        //abc.jpg  提取从.后面开始的字符
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        //上传文件名
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;
        logger.info("开始上传文件,上传文件的文件名:{},上传的路径:{},新文件名:{}",fileName,path,uploadFileName);

        //声明目录file
        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);//赋予可写权限
            fileDir.mkdirs();//递归创建
        }
        //完整的文件
        File targetFile = new File(path, uploadFileName);
        try {
            //是springmvc封装的方法，用于图片上传时，把内存中图片写入磁盘
            file.transferTo(targetFile);
            //文件已经上传成功
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //文件已上传至FTP服务器
            //上传完成后，删除upload下面的文件
            targetFile.delete();
        } catch (IOException e) {
            logger.error("文件上传异常", e);
            return null;
        }
        return targetFile.getName();
    }

}
