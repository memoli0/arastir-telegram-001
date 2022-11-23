import com.google.firebase.FirebaseApp;
import com.google.firebase.database.*;
import com.vdurmont.emoji.EmojiParser;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;

public class myBot extends TelegramLongPollingBot {
    @Override
    public void onUpdateReceived(Update update) {

        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();


        Main main = new Main();
        FirebaseApp.initializeApp(main.firebaseConnect());
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();


        if(message_text.equals("/run")&&(update.getMessage().getText().equals("/run"))){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/1")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            database.child("Deneme").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    response.setText(dataSnapshot.getValue().toString());
                    try {
                        execute(response); // Call method to send the message
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    response.setText("Hata");
                    try {
                        execute(response); // Call method to send the message
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
            });




        } else if(message_text.equals("/2")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/3")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/4")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/5")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/6")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/7")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/8")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/start")){
            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Merhaba ben arasTiR projesinin yardımcı telegram botuyum.");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
            response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Size nasıl yardımcı olabilirim?");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }


        }else if(message_text.equals("/kaynak_kategorileri")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Kategorileri klavyene yönlendiriyorum.");

            // Create ReplyKeyboardMarkup object
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            // Create the keyboard (list of keyboard rows)
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();
            // Create a keyboard row
            KeyboardRow row = new KeyboardRow();
            // Set each button, you can also use KeyboardButton objects if you need something else than text
            row.add("arasTiR kaynak kodları");
            row.add("Android Studio kodlarla anlatım");
            row.add("Telegram bot yapımı");
            // Add the first row to the keyboard
            keyboard.add(row);
            // Create another keyboard row
            row = new KeyboardRow();
            // Set each button for the second line
            row.add("Okuma kitabı kaynakları");
            row.add("Ders kitabı kaynakları");
            row.add("Video ders anlatım kaynakları");
            // Add the second row to the keyboard
            keyboard.add(row);
            // Set the keyboard to the markup
            keyboardMarkup.setKeyboard(keyboard);
            // Add it to the message
            response.setReplyMarkup(keyboardMarkup);

            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }else{
            //TODO
            //Klavye sıfırlama eklenecek
            //Firebase bağlantısı yapılacak
            //Kategori kaydı eklenecek

            String sorry = EmojiParser.parseToUnicode("Ne dediğini anlayamadım :pensive: ");

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText(sorry);

            // Create ReplyKeyboardMarkup object
            ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
            // Create the keyboard (list of keyboard rows)
            ArrayList<KeyboardRow> keyboard = new ArrayList<>();

            KeyboardRow row = new KeyboardRow();
            keyboard.add(row);

            //Set the keyboard to the markup
            keyboardMarkup.setKeyboard(keyboard);
            // Add it to the message
            response.setReplyMarkup(keyboardMarkup);


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void onRegister() {
        super.onRegister();
        
    }

    @Override
    public String getBotUsername() {

        return "kaynak_avcisi_bot";
    }

    @Override
    public String getBotToken() {

        return "5583906777:AAHkP9E8r8mG-28W8vnYJAyDIfCMjkZ8QS4";
    }
}
