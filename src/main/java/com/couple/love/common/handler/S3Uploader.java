package com.couple.love.common.handler;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class S3Uploader {
//    private final AmazonS3Client amazonS3Client;
//    @Value("${cloud.aws.s3.bucket}")
//    private String bucket;
//
//    public String upload(MultipartFile multipartFile, String dirName) throws IOException {
//        File uploadFile = convert(multipartFile)
//                .orElseThrow(() -> new IllegalArgumentException("MultipartFile -> File로 전환이 실패했습니다."));
//        return upload(uploadFile, dirName);
//    }
//
//    private String upload(File uploadFile, String dirName) {
//        String fileName = dirName + "/" + uploadFile.getName();
//        String uploadImageUrl = putS3(uploadFile, fileName);
//        removeNewFile(uploadFile);
//        return uploadImageUrl;
//    }
//
//    private String putS3(File uploadFile, String fileName) {
//        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, uploadFile).withCannedAcl(CannedAccessControlList.PublicRead));
//        return amazonS3Client.getUrl(bucket, fileName).toString();
//    }
//
//    private void removeNewFile(File targetFile) {
//        if (targetFile.delete()) {
//            log.info("targetFile : {} is deleted.", targetFile.getName());
//        } else {
//            log.error("targetFile : {} is not deleted.", targetFile.getName());
//        }
//    }
//
//    private Optional<File> convert(MultipartFile file) throws IOException {
//        File convertFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
//        log.info("MultipartFile -> File converted : {} -> {}", file.getOriginalFilename(), convertFile.getName());
//
//        if(convertFile.createNewFile()) {
//            try (FileOutputStream fos = new FileOutputStream(convertFile)) {
//                fos.write(file.getBytes());
//            }
//            return Optional.of(convertFile);
//        }
//        return Optional.empty();
//    }
}
