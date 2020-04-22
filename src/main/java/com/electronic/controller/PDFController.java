package com.electronic.controller;

import com.electronic.contants.FileConstants;
import com.electronic.dto.FileConvertResultDTO;
import com.electronic.service.FileService;
import com.electronic.service.PreviewService;
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
import java.io.InputStream;
import java.net.URLConnection;
import java.util.List;

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

    @Autowired
    private PreviewService previewService;


    @GetMapping("documentConverterToPdf/{fileName:.+}")
    public ResponseEntity<byte[]> documentConverterToPdf(@PathVariable String fileName, HttpServletResponse response) throws IOException {
        if (StringUtils.isBlank(fileName)) {
            LOGGER.warn("fileName is blank");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        String fileExt = FileUtil.getExtension(fileName);
        //先从以前的仓库中查找
        String tempFilename  = FileUtil.getWithoutExtension(fileName);
        if (FileConstants.fileType2Htmls.contains(fileExt)){
            //判断是否为表格   表格会以html的格式展示
            tempFilename = tempFilename + "."+FileUtil.HTML;
        }else {
            tempFilename = tempFilename +"."+ FileUtil.PDF;
        }

        String filePath = storePath + FileUtil.SLASH_ONE + tempFilename;
        File file = new File(filePath);
        //不存在从新生成
        if (!file.exists()) {
            LOGGER.warn("fileName:{} is not found", fileName);
            org.springframework.core.io.Resource resource = fileService.loadFileAsResource(fileName);
            InputStream stream = resource.getInputStream();
            FileConvertResultDTO convertResultDTO = previewService.convertInputStream2pdf(stream, fileName, fileExt);
            String targetFileName = convertResultDTO.getTargetFileName();
            String targetfilePath = storePath + FileUtil.SLASH_ONE + targetFileName;
            file = new File(targetfilePath);
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

        org.springframework.core.io.Resource resource = fileService.loadFileAsResource(fileName);
        InputStream inputStream = resource.getInputStream();
        FileConvertResultDTO fileConvertResultDTO = previewService.convertInputStream2pdf(inputStream, fileName, "docx");
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
    }

}
