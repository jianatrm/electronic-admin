package com.electronic.controller;

import com.electronic.service.FileService;
import com.electronic.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.jodconverter.DocumentConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;

@RestController
@RequestMapping("/pdf")
public class PDFController {
    public static final Logger LOGGER = LoggerFactory.getLogger(PDFController.class);

    @Resource
    private DocumentConverter documentConverter;

    @Autowired
    private FileService fileService;

    @Value("${jodconverter.store.path}")
    private String storePath;


    @GetMapping("documentConverterToPdf/{fileName:.+}")
    public ResponseEntity<byte[]> documentConverterToPdf(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(fileName)) {
            LOGGER.warn("fileName is blank");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String fileExt = FileUtil.getExtension(fileName);
        if (StringUtils.isBlank(fileExt)) {
            fileName = fileName + FileUtil.PDF;
        }
        String filePath = storePath + FileUtil.SLASH_ONE + fileName;
        File file = new File(filePath);


        if (!file.exists()) {
            LOGGER.warn("fileName:{} is not found", fileName);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        try {
            //判断文件类型
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType == null) {
                mimeType = "application/octet-stream";
            }
            response.setContentType(mimeType);

            //设置文件响应大小
            response.setContentLengthLong(file.length());

            byte[] bytes = FileUtil.readFileToByteArray(file);
            response.getOutputStream().write(bytes);
            return new ResponseEntity<>(bytes, HttpStatus.OK);
        } catch (IOException e) {
            LOGGER.error("readFile error:" + e.getMessage(), e);
        }
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

}
