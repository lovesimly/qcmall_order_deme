package com.qcmall.order.utils;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lujingzhong
 */
public class FileUpload {

    //public static final String FILE_PATH = "/upload/";

    //文件上传
    public static String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();
        String path = request.getSession().getServletContext().getRealPath("upload");
        File tempFile = new File(path, new Date().getTime() + String.valueOf(fileName));
        if (!tempFile.getParentFile().exists()) {
            tempFile.getParentFile().mkdir();
        }
        if (!tempFile.exists()) {
            tempFile.createNewFile();
        }
        file.transferTo(tempFile);
        return "/order-web/download.do?fileName=" + tempFile.getName();
    }

    public static File getFile(String path, String fileName) {
        return new File(path, fileName);
    }
}