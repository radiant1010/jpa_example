package com.jpa.demo.util;

import com.jpa.demo.example.domain.dto.ExampleFileDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class FileUtil {

    @Value("${spring.servlet.multipart.location}")
    private String fileDir;

    public String getFullPath(String filename) {
        return fileDir + filename;
    }
    
    //여러개 업로드
    public List<ExampleFileDTO> uploadFiles(MultipartFile[] multipartFiles) throws IOException {
        List<ExampleFileDTO> list = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                list.add(uploadFile(multipartFile));
            }
        }
        return list;
    }
    
    //1개 업로드
    public ExampleFileDTO uploadFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            return null;
        }
        
        //NOTICE : 필요한 파일 정보 DTO에 추가 후 여기도 추가(e.g. 확장자 체크 로직 등등이 들어갈 수 있음)
        String originalFilename = multipartFile.getOriginalFilename();
        String storeFileName = createStoreFileName(originalFilename);
        //String fileContentType = file.getContentType(); //파일 타입
        multipartFile.transferTo(new File(getFullPath(storeFileName)));

        return new ExampleFileDTO(originalFilename, storeFileName, fileDir);
    }
    
    //중복이름 방지 | 폴더 추가등 정책에 맞게 설정 필요
    private String createStoreFileName(String originalFilename) {
        String ext = extractExt(originalFilename);
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext;
    }
    
    //확장자 가져오기
    private String extractExt(String originalFilename) {
        int pos = originalFilename.lastIndexOf(".");
        return originalFilename.substring(pos + 1);
    }
}
