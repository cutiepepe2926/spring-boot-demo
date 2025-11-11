package com.example.basic.chap07;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/chap07")
public class chap07Controller {

    private final DataSource dataSource;
    //파일 업로드 경로
    @Value("${project.upload.path}")
    String uploadPath;

    public chap07Controller(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //화면처리
    @GetMapping("/upload")
    public String upload(){
        return "chap07/upload";
    }

    //폴더 생성 메서드
    public String makeFolder() {
        String path = LocalDate.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        File file = new File(uploadPath + "/" + path);
        if (!file.exists()) {
            file.mkdirs(); //폴더를 생성
        }
        return path;
    }

    //단일파일 업로드
    @PostMapping("/upload_ok")
    public String upload_ok(@RequestParam("file") MultipartFile file)  {

        try {
            // 1. 브라우저 별로 사용자의 경로가 앞에 붙어서 들어오는 경우가 있기 때문에 //기준으로 절삭
            // 2. 동일한 이름으로 올라오는 건 덮어쓰기가 되므로 구분해서 해줘야함
            // 3. 윈도우 시스템의 경우, 폴더 하나에 저장될 수 있는 파일의 갯수가 65536개정도

            String originalFilename = file.getOriginalFilename(); //파일의 이름
            String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\") +1);
            long fileSize = file.getSize(); //파일 사이즈
            byte[] arr = file.getBytes(); //파일의 바이트코드

            String uuid = UUID.randomUUID().toString(); //랜덤한 16진수 난수 출력
            String filePath = makeFolder();
            String path = uploadPath + "/"+ filePath +"/"+ uuid +"_"+ fileName;
            File saveFile = new File(path);
            file.transferTo(saveFile); //업로드 처리

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "chap07/upload_ok";
    }

    //multiple 옵션
    @PostMapping("upload_ok2")
    public String upload_ok2(@RequestParam("file")List<MultipartFile> files) {

        try {
            // 반복으로 복수 개의 파일 처리
            for (MultipartFile file : files) {
                // 1. 브라우저 별로 사용자의 경로가 앞에 붙어서 들어오는 경우가 있기 때문에 //기준으로 절삭
                // 2. 동일한 이름으로 올라오는 건 덮어쓰기가 되므로 구분해서 해줘야함
                // 3. 윈도우 시스템의 경우, 폴더 하나에 저장될 수 있는 파일의 갯수가 65536개정도

                String originalFilename = file.getOriginalFilename(); //파일의 이름
                String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\") +1);

                String uuid = UUID.randomUUID().toString(); //랜덤한 16진수 난수 출력
                String filePath = makeFolder();
                String path = uploadPath + "/"+ filePath +"/"+ uuid +"_"+ fileName;
                File saveFile = new File(path);
                file.transferTo(saveFile); //업로드 처리
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "chap07/upload_ok2";
    }

    @PostMapping("/upload_ok3")
    public String upload_ok3(@RequestParam("file") List<MultipartFile> files) {

        //사용자가 올리지 않은 빈 데이터를 필터링함.
        files = files.stream()
                .filter(data -> !data.isEmpty())
                .collect(Collectors.toList());

        try {
            for (MultipartFile file : files) {
                // 1. 브라우저 별로 사용자의 경로가 앞에 붙어서 들어오는 경우가 있기 때문에 //기준으로 절삭
                // 2. 동일한 이름으로 올라오는 건 덮어쓰기가 되므로 구분해서 해줘야함
                // 3. 윈도우 시스템의 경우, 폴더 하나에 저장될 수 있는 파일의 갯수가 65536개정도

                String originalFilename = file.getOriginalFilename(); //파일의 이름
                String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\") +1);

                String uuid = UUID.randomUUID().toString(); //랜덤한 16진수 난수 출력
                String filePath = makeFolder();
                String path = uploadPath + "/"+ filePath +"/"+ uuid +"_"+ fileName;
                File saveFile = new File(path);
                file.transferTo(saveFile); //업로드 처리
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "chap07/upload_ok3";
    }

    // 비동기 파일 업로드
    @PostMapping("/upload_ok4")
    @ResponseBody //응답이 요청온 곳으로 간다.
    public String upload_ok4(@RequestParam("file") MultipartFile file) {

        try {
            // 1. 브라우저 별로 사용자의 경로가 앞에 붙어서 들어오는 경우가 있기 때문에 //기준으로 절삭
            // 2. 동일한 이름으로 올라오는 건 덮어쓰기가 되므로 구분해서 해줘야함
            // 3. 윈도우 시스템의 경우, 폴더 하나에 저장될 수 있는 파일의 갯수가 65536개정도

            String originalFilename = file.getOriginalFilename(); //파일의 이름
            String fileName = originalFilename.substring(originalFilename.lastIndexOf("\\") +1);
            long fileSize = file.getSize(); //파일 사이즈
            byte[] arr = file.getBytes(); //파일의 바이트코드

            String uuid = UUID.randomUUID().toString(); //랜덤한 16진수 난수 출력
            String filePath = makeFolder();
            String path = uploadPath + "/"+ filePath +"/"+ uuid +"_"+ fileName;
            File saveFile = new File(path);
            file.transferTo(saveFile); //업로드 처리

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
