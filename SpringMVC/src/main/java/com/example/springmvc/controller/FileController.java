package com.example.springmvc.controller;

import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Controller
public class FileController {

    @Autowired
    private ResourceLoader resourceLoader;

    @GetMapping("/file")
    public String fileUploadForm(Model model){

        model.getAttribute("message");
        return "files/index";
    }

    @PostMapping("/file")
    public String fileUpload(@RequestParam MultipartFile file, RedirectAttributes redirectAttributes){
        //
        String message = file.getOriginalFilename() + "is upload";

        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/file";
    }

    @GetMapping("file/{fileName}")
    @ResponseBody
    public ResponseEntity fileDownLoad(@PathVariable String fileName) throws IOException {
        Resource resource = resourceLoader.getResource("classpath:"+fileName);

        File file = resource.getFile();

        Tika tika = new Tika();

        String mediaType = tika.detect(file);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, mediaType)
                .header(HttpHeaders.CONTENT_LENGTH, file.length() + "")
                .body(resource);
    }
}

