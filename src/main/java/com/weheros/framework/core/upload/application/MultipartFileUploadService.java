/**
 * Copyright (c) 2011-2014 iTel Technology Inc,All Rights Reserved.
 */
	
package com.weheros.framework.core.upload.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.weheros.framework.core.exception.UploadFileException;
import com.weheros.framework.core.infrastructure.filesystem.FileSystemAccessFactory;
import com.weheros.framework.core.log.LogService;
import com.weheros.framework.core.upload.domain.SourceFile;
import com.weheros.framework.core.upload.format.PictureService;

/**
 * @ClassName: MultipartFileUploadService 
 * @author Administrator
 * @date 2014年12月15日 下午4:45:28
 */
@Service("multipartFileUploadService")
public class MultipartFileUploadService implements IMultipartFileUpload {
    
	public List<SourceFile> upload(MultipartFile[] files) throws UploadFileException {
		List<SourceFile> sources=new ArrayList<SourceFile>();
	    for(MultipartFile file:files){
	    	if(file.isEmpty()){
	    		throw new UploadFileException("the_upload_file_stream_is_empty:"+file.getOriginalFilename());
	    	}
	    	LogService.info(FileUploadService.class, "---The origin file name is---"+file.getOriginalFilename());
	
		    String url="";
			try {
				url = FileSystemAccessFactory.buildFileSystemAccess().uploadFile(file.getInputStream(), "");
			} catch (IOException e) {
				LogService.fatal(MultipartFileUploadService.class, "--- uploadFile error ---",e);
				throw new UploadFileException("---uploadAndFormatPictures error---",e);
			}
		    SourceFile source=new SourceFile(file.getOriginalFilename(),url,file.getContentType());
		    sources.add(source);
	    }
		return sources;
		
	}
	


	@Override
	public List<SourceFile> uploadAndFormatPictures(MultipartFile[] files)
			throws UploadFileException {
		List<SourceFile> sources=new ArrayList<SourceFile>();
	    for(MultipartFile file:files){
	    	if(file.isEmpty()){
	    		throw new UploadFileException("the_upload_file_stream_is_empty:"+file.getOriginalFilename());
	    	}
	    	LogService.info(FileUploadService.class, "---The origin file name is---"+file.getOriginalFilename());

	    	SourceFile source=null;
			try {
				source = PictureService.formatAndUpload(file.getOriginalFilename(),file.getContentType(),file.getInputStream());
			} catch (InterruptedException | ExecutionException | IOException e) {
				LogService.fatal(MultipartFileUploadService.class, "--- formatAndUpload error ---",e);
				throw new UploadFileException("---uploadAndFormatPictures error---",e);
			}
	    	sources.add(source);
	    }
		return sources;
	}

}
