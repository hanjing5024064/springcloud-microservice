package cn.mldn.mldncloud.rest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@RestController
public class UploadRest {
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@HystrixCommand
	public Object upload(@RequestParam("photo") MultipartFile photo,HttpServletRequest request) throws Exception {
		Map<String,Object> map = new HashMap<String,Object>() ;
		String fileName = "mldn-file-nophoto" ;
		if (photo != null) {								// 有文件上传
			map.put("photo-name", photo.getName()) ;
			map.put("content-type", photo.getContentType()) ;
			map.put("photo-size", photo.getSize()) ;
			fileName = "mldn-file-" + UUID.randomUUID() + "."
					+ photo.getContentType().substring(
							photo.getContentType().lastIndexOf("/") + 1);	// 创建文件名称
			System.out.println(fileName);
			String filePath = request.getServletContext().getRealPath("/") + fileName;
			photo.transferTo(new File(filePath));			// 文件保存
			map.put("save-path", filePath) ;
			map.put("save-file", fileName) ;
		} 
		return map ;
	}
}
