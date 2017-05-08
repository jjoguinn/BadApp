package com.fedex.broken;

import java.util.Collection;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class BadController {

    private BadPojo badPojo;

    public BadController() throws Throwable {

        System.out.println("Starting BadApp...");

        badPojo = new BadPojo();
    }

    @PostMapping("/storeFile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {

        badPojo.storeTheRequest(file);

        return "Stored\n";
    }

    @RequestMapping(value = "/listFiles")
    public @ResponseBody Collection listFiles() {

        return badPojo.listFiles();


    }

    @RequestMapping(value = "/setNbrCopies")
    public @ResponseBody Boolean setNbrCopies(
            @RequestBody Integer reqContents) {

        badPojo.setNbrCopies(reqContents);

        return true;
    }
}
