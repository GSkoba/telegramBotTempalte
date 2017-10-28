package org.telegram.updateshandlers;

import org.telegram.bot.skobelev.BotConfig;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.logging.BotLogger;

public class MyProjectHandler extends TelegramLongPollingBot{

    private static final String TAG = MyProjectHandler.class.getSimpleName();

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()){

            Message message = update.getMessage();

            if (message.hasText()){

                SendMessage sendMessageRequest = new SendMessage();
                sendMessageRequest.setChatId(message.getChatId().toString());
                sendMessageRequest.setText("you said: " + message.getText());

                try{

                    sendMesg(sendMessageRequest);

                }catch (TelegramApiException ex){

                    BotLogger.error("Error with send message", TAG,ex);

                }//end catch()

            } //end if()

        } //end if ()

    }

    @SuppressWarnings("deprecation")
    public void sendMesg(SendMessage sendMessageRequest) throws TelegramApiException{
        sendMessage(sendMessageRequest);
    }

    @Override
    public String getBotUsername() {
        //TODO Auto-generated method stub
        return BotConfig.USERNAMEMYPROJECT;
    }

    @Override
    public String getBotToken() {
        //TODO Auto-generated method stub
        return BotConfig.TOKENMYPROJECT;
    }
}
