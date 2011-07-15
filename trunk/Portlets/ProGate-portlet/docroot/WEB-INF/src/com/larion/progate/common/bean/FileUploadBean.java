package com.larion.progate.common.bean;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MultipartFile file;

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public MultipartFile getFile() {
        return file;
    }
}