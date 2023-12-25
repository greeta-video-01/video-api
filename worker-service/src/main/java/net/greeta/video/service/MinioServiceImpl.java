package net.greeta.video.service;

import net.greeta.video.config.MinioConfiguration;
import io.minio.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MinioServiceImpl implements MinioService {
  @Autowired MinioClient minioClient;
  @Autowired MinioConfiguration minioConfiguration;

  @Override
  public void uploadObject(File file, String bucket, String objectName) throws Exception {
    minioClient.uploadObject(
        UploadObjectArgs.builder()
            .bucket(bucket)
            .object(objectName)
            .filename(file.getAbsolutePath())
            .build());
  }

  @Override
  public void putFolder(String bucket, String folderName) throws Exception {
    minioClient.putObject(
        PutObjectArgs.builder().bucket(bucket).object(folderName).stream(
                new ByteArrayInputStream(new byte[] {}), 0, -1)
            .build());
  }

  @Override
  public File downloadObject(String bucket, String objectName, String outputName) throws Exception {
      try (InputStream stream = minioClient.getObject(
          GetObjectArgs.builder()
              .bucket(bucket)
              .object(objectName)
              //.filename(outputName)
              //.overwrite(true)
              .build())) {
        try {
          File file = Files.createTempFile(outputName, "").toFile();
          FileUtils.copyInputStreamToFile(stream, file);
          if (!file.exists()) throw new RuntimeException();
          return file;
        } catch (Exception e) {
          e.printStackTrace();
          throw new Exception("cannot retrieve file !");
        }
      }
  }

  @Override
  public void removeObject(String bucket, String objectName) throws Exception {
    minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(objectName).build());
  }
}
