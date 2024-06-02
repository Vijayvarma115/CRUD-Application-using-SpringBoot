package com.example.firebase_crud;

import com.example.firebase_crud.User;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.auth.oauth2.GoogleCredentials;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private static UserService userService;

    @BeforeAll
    public static void setUp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccountKey.json");

        @SuppressWarnings("deprecation")
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .build();

        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseApp.initializeApp(options);
        }

        userService = new UserService();
    }

    @Test
    public void testCreateUser() throws InterruptedException, ExecutionException {
        User user = new User();
        user.setId("1");
        user.setName("John Doe");
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", 95);
        marks.put("Science", 90);
        user.setSubjectMarks(marks);

        String result = userService.createUser(user);
        assertNotNull(result);
    }

    @Test
    public void testGetUser() throws InterruptedException, ExecutionException {
        User user = userService.getUser("1");
        assertNotNull(user);
        assertEquals("John Doe", user.getName());
    }

    @Test
    public void testUpdateUser() throws InterruptedException, ExecutionException {
        User user = new User();
        user.setId("1");
        user.setName("John Doe Updated");
        Map<String, Integer> marks = new HashMap<>();
        marks.put("Math", 95);
        marks.put("Science", 90);
        user.setSubjectMarks(marks);

        String result = userService.updateUser(user);
        assertNotNull(result);
    }

    @Test
    public void testDeleteUser() {
        String result = userService.deleteUser("1");
        assertEquals("Document with ID 1 has been deleted", result);
    }
}