package com.Review_API.Security;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class FirebaseConfig {
    private final String firebaseCredentials;

    @Autowired
    public FirebaseConfig(@Value("${GOOGLE_CREDENTIALS}") String firebaseCredentials) {
        this.firebaseCredentials = firebaseCredentials;
    }

    @Bean @Primary
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
