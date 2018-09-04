package com.yyc.service;

import com.yyc.dao.ReaderMapper;
import com.yyc.entity.Reader;
import com.yyc.exception.IllegalException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * Created by yyc on 2018/8/18.
 */
@Service
public class FileService {

    @Autowired
    ReaderMapper readerMapper;

    private ServletFileUpload getUpload(String tempFileUrl){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        /**配置各属性参数*/
        factory.setSizeThreshold(1024*500);
        File tempFile=new File(tempFileUrl);
        factory.setRepository(tempFile);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax(1024*1024*5);
        return upload;
    }

    private String getFileName(String fileUrl){
        String[] arrays = fileUrl.split("\\\\");
        fileUrl = arrays[arrays.length - 1];
        int index = fileUrl.lastIndexOf(".");
        fileUrl = fileUrl.substring(index, fileUrl.length());
        fileUrl = Math.random() + fileUrl;
        return fileUrl;
    }

    private boolean validateFileSuffix(String fileUrl){
        if (fileUrl.endsWith(".jpg") || fileUrl.endsWith(".jpeg") || fileUrl.endsWith(".png") || fileUrl.endsWith(".gif")){
            return true;
        }
        return false;
    }

    public Reader processUpload(HttpServletRequest request,String tempUrl,String targetUrl) throws IOException {
        ServletFileUpload upload = getUpload(tempUrl);
        Reader reader = null;
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items){
                if (item.isFormField()){
                    String id = item.getString("utf-8");
                    reader = readerMapper.getReader(id);
                }
            }

            for (FileItem item:items){
                if (!item.isFormField()){
                    String fileName = item.getName();
                    if (fileName.isEmpty()){
                        return reader;
                    }
                    if (!validateFileSuffix(fileName)){
                        throw new IllegalException("非法图片文件");
                    }
                    fileName = getFileName(fileName);

                    InputStream in = item.getInputStream();
                    String targetPath = targetUrl + fileName;
                    reader.setPictureUrl(fileName);
                    OutputStream out = new FileOutputStream(targetPath);
                    int len = 0;
                    byte[] buffer = new byte[1024];

                    while ((len = in.read(buffer)) != -1){
                        out.write(buffer,0,len);
                    }

                   out.close();
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }catch (IllegalException e){
            throw e;
        }
        return  reader;
    }

}
