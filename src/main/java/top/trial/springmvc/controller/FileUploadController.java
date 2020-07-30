package top.trial.springmvc.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 测试文件上传
 *
 * @Author gaoyx1469
 * @Date 2020/7/30
 * @Version 1.0
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    /**
     * 跳转至文件上传页面
     *
     * @return String
     */
    @RequestMapping("/uploadPage")
    public String gotoFileUploadPage() {
        return "fileUploadPage";
    }

    /**
     * 传统方式上传文件
     *
     * @param request HttpServletRequest
     * @return String
     */
    @RequestMapping("/oldWay")
    public String oldFileUploadWay(HttpServletRequest request) {

        System.out.println("文件上传");
        //文件上传目标路径
        String distPath = request.getSession().getServletContext().getRealPath("/uplaodFile");
        File file = new File(distPath);
        if (!file.exists())
            file.mkdirs();

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                if (!item.isFormField()) {//非表单项
                    String fileName = item.getName();
                    String newFileName = UUID.randomUUID().toString().replace("-", "") + "_" + fileName;//重定义文件名
                    item.write(new File(distPath, newFileName));//写入文件
                    item.delete();//清除缓存
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fileUploadSuccess";
    }

    /**
     * 使用SpringMVC文件解析器上传文件
     *
     * @param filename MultipartFile  参数名称需要与表单中file标签的name属性值一致
     * @return String
     */
    @RequestMapping("newWay")
    public String springMVCFileUploadWay(HttpServletRequest request, MultipartFile filename) {

        System.out.println("springMVC文件上传");
        //文件上传目标路径
        String distPath = request.getSession().getServletContext().getRealPath("/uplaodFile");
        File file = new File(distPath);
        if (!file.exists())
            file.mkdirs();
        String fileName = filename.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString().replace("-", "") + "_" + fileName;//重定义文件名
        try {
            filename.transferTo(new File(distPath, newFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "fileUploadSuccess";
    }

}
