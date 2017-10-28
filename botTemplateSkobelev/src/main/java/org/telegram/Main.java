package org.telegram;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.logging.BotLogger;
import org.telegram.updateshandlers.MyProjectHandler;

public class Main {

    private static final String TAG = Main.class.getSimpleName();

    public static void main(String[] args) {

        ApiContextInitializer.init();

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();

        try{
            telegramBotsApi.registerBot(new MyProjectHandler());
        }catch (TelegramApiException ex){
            BotLogger.error("Error with registors", TAG, ex);
        }

    }
}
