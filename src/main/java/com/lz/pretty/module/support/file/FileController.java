package com.lz.pretty.module.support.file;

import com.lz.pretty.common.utils.StringUtils;
import com.lz.pretty.config.PrettyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 类描述:
 *
 * @author Lz on 2022-07-25
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private PrettyConfig prettyConfig;

    @GetMapping("/downloadLocal")
    public void downloadLocal(String fileName, HttpServletResponse response) throws IOException {
        if (StringUtils.isEmpty(fileName)) {
            fileName = "pic.png";
        }

        // 读到流中
        FileInputStream inputStream = new FileInputStream(prettyConfig.getProfile() + fileName);
        response.reset();
        response.setContentType("application/octet-stream");
        String filename = new File(prettyConfig.getProfile() + fileName).getName();
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = inputStream.read(b)) > 0) {
            outputStream.write(b, 0, len);
        }
        inputStream.close();
    }
}
