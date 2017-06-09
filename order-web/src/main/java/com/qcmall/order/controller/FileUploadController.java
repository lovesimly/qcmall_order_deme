package com.qcmall.order.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.qcmall.order.utils.FileUpload;

/**
 * @author lujingzhong
 */
@Controller
public class FileUploadController {

    Logger logger = LoggerFactory.getLogger(FileUploadController.class);

    @RequestMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request,
                       HttpServletResponse response) throws IOException {
        String filePath = FileUpload.uploadFile(file, request);
        logger.info("filePath:" + filePath);
        response.setContentType("text/html;charset=utf8");
        response.getWriter().write("<img src='" + filePath + "'/>");
    }

    @RequestMapping("/download")
    public void download(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getSession().getServletContext().getRealPath("upload");
        OutputStream os = response.getOutputStream();
        try {
            response.reset();
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
            response.setContentType("image/jpeg; charset=utf-8");
            os.write(FileUtils.readFileToByteArray(FileUpload.getFile(path, fileName)));
            os.flush();
        } finally {
            if (os != null) {
                os.close();
            }
        }
    }

    @RequestMapping(value = "/upload2", method = RequestMethod.POST)
    public String upload(HttpServletRequest request, @RequestParam("file") MultipartFile file, ModelMap model) {
        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        // String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        // 保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);
        return "result";
    }

}
