package com.weheros.framework.core.upload.front;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.weheros.framework.core.front.CodeDefinition;
import com.weheros.framework.core.front.Message;
import com.weheros.framework.core.upload.application.FileUploadService;
import com.weheros.framework.core.upload.application.IFileUploadService;
import com.weheros.framework.core.utils.ToJson;
/**
 *  纯粹的servlet支持上传文件到服务器。
  * @ClassName: CommonUploadServlet 
  * @author Administrator
  * @date 2014年12月17日 下午4:40:55
 */
public class CommonUploadServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CommonUploadServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		IFileUploadService uploadService=new FileUploadService();
		uploadService.uploadFiles(request);
		Message message=new Message(Message.VISIT_SUCCESS,CodeDefinition.LOGIN_SUCCESS.getCode(),"Congratulations,upload file sucess.");
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(ToJson.toJson(message));
	}

	
}
