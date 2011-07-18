package com.larion.progate.common.bean;

import org.springframework.web.multipart.MultipartFile;

public class MultiPartFileUploadBean {

    private String type;

    private MultipartFile[] files;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFiles(MultipartFile[] file) {
        this.files = file;
    }

    public MultipartFile[] getFiles() {
        return files;
    }

}
