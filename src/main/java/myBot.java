import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class myBot extends TelegramLongPollingBot {
    private final String token = "5583906777:AAHkP9E8r8mG-28W8vnYJAyDIfCMjkZ8QS4";
    @Override
    public void onUpdateReceived(Update update) {

        String message_text = update.getMessage().getText();
        long chat_id = update.getMessage().getChatId();



        String command = message_text;

        if(command.equals("/run")){

            SendMessage response = new SendMessage();
            response.setChatId(chat_id);
            response.setText("Hey bro");


            try {
                execute(response); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public String getBotUsername() {

        return "kaynak_avcisi_bot";
    }

    @Override
    public String getBotToken() {

        return token;
    }
}
