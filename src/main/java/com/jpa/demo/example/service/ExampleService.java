package com.jpa.demo.example.service;

import com.jpa.demo.ExampleIdGen.domain.repository.ExampleIdGenRepository;
import com.jpa.demo.example.domain.dto.ExampleFileDTO;
import com.jpa.demo.example.domain.dto.FindExampleDTO;
import com.jpa.demo.example.domain.dto.SaveExampleReqDTO;
import com.jpa.demo.example.domain.dto.UpdateExampleReqDTO;
import com.jpa.demo.example.domain.entity.Example;
import com.jpa.demo.example.domain.entity.ExampleFile;
import com.jpa.demo.example.domain.repository.ExampleFileRepository;
import com.jpa.demo.example.domain.repository.ExampleRepository;
import com.jpa.demo.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ExampleService {

    private final ExampleRepository exampleRepository;
    private final ExampleIdGenRepository idGeneratorRepository;
    private final ExampleFileRepository exampleFileRepository;

    private final FileUtil fileUtil;

    //단건 생성
    @Transactional
    public String createExample(SaveExampleReqDTO dto){
        //Dto를 entity 변환 해서 저장
        return exampleRepository.save(dto.toEntity()).getId();
    }

    //리스트 생성 | JPA Bulk insert 사용
    @Transactional
    public List<String> createExamples(List<SaveExampleReqDTO> dtos) {
        //바로 entity를 빌드 리스트로 만들어 DB에 저장
        List<Example> examples = dtos.stream()
                .map(SaveExampleReqDTO::toEntity)
                .collect(Collectors.toList());

        List<Example> savedExamples = exampleRepository.saveAll(examples);

        return savedExamples.stream()
                .map(Example::getId)
                .collect(Collectors.toList());
    }

    //User Id로 유저 정보 단건 조회
    public FindExampleDTO getExample(String id){
        Example entity = exampleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("해당 " + id + "를 찾을 수 없습니다."));
        return FindExampleDTO.toEntity(entity);
    }

    //리스트 조회
    public List<FindExampleDTO> getExamples(){
        return exampleRepository.findAll().stream()
                .map(FindExampleDTO::toEntity)
                .collect(Collectors.toList());
    }

    //단건 수정(Soft Delete도 동일) | JPQL 문법
    @Transactional
    public void updateExample(UpdateExampleReqDTO dto) {
        exampleRepository.updateExampleEmail(dto.getId(), dto.getEmail());
    }

    //복수 수정 | Bulk 연산 | JPA Dirty Checking 사용 || FIXME : jdbcTemplate 사용해서 case when 동적으로 생성되는 코드로 변경 가능?
    @Transactional
    public void updateExamples(List<UpdateExampleReqDTO> dtos){
        //트랜잭션 관리는 상황에 맞게 적용
        for (UpdateExampleReqDTO dto: dtos) {
            exampleRepository.findById(dto.getId())
                    .ifPresentOrElse(example -> example.updateEmail(dto.getEmail()),
                            () -> { throw new NoSuchElementException("ID가 존재하지 않습니다: " + dto.getId()); });
        }
    }

    //사진 업로드 | 반환 타입은 DB ID에 맞게 수정 or 원하는 방식의 DTO로 넘겨주기
    @Transactional
    public List<Long> saveFile(MultipartFile[] multipartFiles) throws IOException{
        List<ExampleFileDTO> fileList = fileUtil.uploadFiles(multipartFiles); //파일 업로드

        List<ExampleFile> fileUpload = fileList.stream()
                .map(ExampleFileDTO::toEntity)
                .collect(Collectors.toList());
        //DB에 저장
        List<ExampleFile> saveFile = exampleFileRepository.saveAll(fileUpload);

        return saveFile.stream()
                .map(ExampleFile::getId)
                .collect(Collectors.toList());
    }
    
    //페이지네이션

}
