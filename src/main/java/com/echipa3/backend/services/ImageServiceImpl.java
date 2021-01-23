package com.echipa3.backend.services;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.echipa3.backend.entities.Image;
import com.echipa3.backend.repositories.IRepoImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class ImageServiceImpl implements IImageService {

    private static final String HTTPS = "https://";

    private static final String S3 = "s3";

    private static final String AMAZON_AWS_DOT_COM = "amazonaws.com";

    @Autowired
    private IRepoImage repoImage;

    @Value("${aws.s3.bucket-name}")
    private String s3BucketName;

    @Value("${aws.s3.region}")
    private String s3Region;

    @Value("${aws.access-key}")
    private String awsAccessKey;

    @Value("${aws.secret-key}")
    private String awsSecretKey;

    private AmazonS3 s3Client;

    private String s3BaseUrl;

    @Override
    public Image saveImage(byte[] imageBytes, String imageName, String imageContentType) {
        String imageUrl = uploadImageInS3(imageBytes, imageName, imageContentType);

        Image image = new Image(Math.abs(new Random().nextLong()), imageUrl); // TODO genereaza id-ul automat
        repoImage.save(image);

        return image;
    }

    public String uploadImageInS3(byte[] imageBytes, String imageName, String imageContentType) {
        String imageKey = createImageKey(imageName);

        ByteArrayInputStream imageInputStream = new ByteArrayInputStream(imageBytes);

        ObjectMetadata imageMetadata = new ObjectMetadata();
        imageMetadata.setContentType(imageContentType);
        imageMetadata.setContentLength(imageBytes.length);

        PutObjectRequest putRequest = new PutObjectRequest(s3BucketName, imageKey, imageInputStream, imageMetadata);
        putRequest.withCannedAcl(CannedAccessControlList.PublicRead);

        getS3Client().putObject(putRequest);

        return getS3BaseUrl() + "/" + imageKey;
    }

    private String createImageKey(String imageName) {
        String extension = "";
        if (imageName.contains(".")) {
            extension = imageName.substring(imageName.lastIndexOf("."));
        }

        return UUID.randomUUID() + extension;
    }

    private AmazonS3 getS3Client() {
        if (s3Client == null) {
            BasicAWSCredentials credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
            s3Client = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(s3Region)
                    .build();
        }

        return s3Client;
    }

    private String getS3BaseUrl() {
        if (s3BaseUrl == null) {
            s3BaseUrl = HTTPS + s3BucketName + "." + S3 + "." + s3Region + "." + AMAZON_AWS_DOT_COM;
        }

        return s3BaseUrl;
    }

}
