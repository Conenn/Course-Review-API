package com.Review_API.Security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FirebaseConfig {

    private final String firebaseCredentials;

    public FirebaseConfig(@Value("${SERVICE_ACCOUNT}") String firebaseCredentials) {
        this.firebaseCredentials = firebaseCredentials;
    }

    @Primary
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        if (FirebaseApp.getApps().isEmpty()) {
            InputStream credentialsStream = new ByteArrayInputStream(firebaseCredentials.getBytes());
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(credentialsStream)).build();
            FirebaseApp.initializeApp(options);
        }
        return FirebaseApp.getInstance();
    }

    @Bean
    public FirebaseAuth firebaseAuth() throws IOException {
        return FirebaseAuth.getInstance(firebaseApp());
    }

}
//package com.Review_API.Security;
//
//import com.Review_API.Properties.SecurityProperties;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.io.ClassPathResource;
//import java.io.IOException;
//import java.io.InputStream;
//
//@Configuration
//public class FirebaseConfig {
//
//    @Autowired
//    SecurityProperties secProps;
//
//    @Primary
//    @Bean
//    public void firebaseInit() {
//        InputStream inputStream = null;
//        try {
//            inputStream = new ClassPathResource("firebase_config.json").getInputStream();
//        } catch (IOException e3) {
//            e3.printStackTrace();
//        }
//        try {
//
//            FirebaseOptions options = new FirebaseOptions.Builder()
//                    .setCredentials(GoogleCredentials.fromStream(inputStream))
//                    .build();
//
//            if (FirebaseApp.getApps().isEmpty()) {
//                FirebaseApp.initializeApp(options);
//            }
//            System.out.println("Firebase Initialize");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
