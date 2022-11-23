import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.*;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.FileInputStream;
import java.io.IOException;

public class Main {

    public static void main(String [] args){

        try {
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            botsApi.registerBot(new myBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }


        FirebaseOptions options;
        try (FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json")) {

            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://arastir-telegram-default-rtdb.firebaseio.com")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        FirebaseApp.initializeApp(options);



        // Shared Database reference
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        database.child("Deneme").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                System.out.println(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("hata");
            }
        });

    }

    public FirebaseOptions firebaseConnect(){
        FirebaseOptions options;
        try (FileInputStream serviceAccount = new FileInputStream("./serviceAccountKey.json")) {

            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://arastir-telegram-default-rtdb.firebaseio.com")
                    .build();
            return options;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
