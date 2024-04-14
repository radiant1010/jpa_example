package com.jpa.demo.example.controller;

import com.jpa.demo.example.domain.dto.ExampleFileDTO;
import com.jpa.demo.example.domain.dto.FindExampleDTO;
import com.jpa.demo.example.domain.dto.SaveExampleReqDTO;
import com.jpa.demo.example.domain.dto.UpdateExampleReqDTO;
import com.jpa.demo.example.service.ExampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/v1/example")
public class ExampleApiController {

    private final ExampleService exampleServicel;

    @PostMapping("/user")
    public void saveUser(@RequestBody SaveExampleReqDTO dto){
        log.info("[POST users] : api test : {}, {}, {}",dto.getId(), dto.getEmail(), dto.getPassword());
        String saveExample = exampleServicel.createExample(dto);
        log.info(saveExample);
    }

    @PostMapping("/users")
    public void saveUsers(@RequestBody List<SaveExampleReqDTO> dto){
        List<String> saveExamples = exampleServicel.createExamples(dto);
        log.info(saveExamples.toString());
    }

    @GetMapping("/user")
    public void findUser(@RequestBody FindExampleDTO dto){
        FindExampleDTO findExample = exampleServicel.getExample(dto.getId());
        log.info(findExample.toString());
    }

    @GetMapping("/users")
    public void findUsers(){
        List<FindExampleDTO> findExample = exampleServicel.getExamples();
        log.info(findExample.toString());
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UpdateExampleReqDTO dto){
        exampleServicel.updateExample(dto);
    }

    @PutMapping("/users")
    public void updateUsers(@RequestBody List<UpdateExampleReqDTO> dtos){
        exampleServicel.updateExamples(dtos);
    }

    //파일 업로드
    @GetMapping("/file")
    public String fileuploadPage(Model model) {
        return "fileUpload";
    }

    @PostMapping("/file")
    public String upload(@RequestParam MultipartFile[] multipartFiles, Model model)
            throws IllegalStateException, IOException {

        exampleServicel.saveFile(multipartFiles);
        //TODO : 업로드 하고 필요한 동작 처리(e.g. 리디렉션을 하겠다, 엑셀파일 추출해서 화면에 뿌려 주겠다 등등)

        //1. 화면 리디렉션(추가 : RedirectAttributes redirectAttributes)
        //redirectAttributes.addAttribute("게시글 id", 게시글.getId());
        //return "redirect:/게시글/{게시글}";
        
        return "업로드 성공";
    }

    //파일 다운로드

}
