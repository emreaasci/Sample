package org.csystem.app.samples.commandprompt;

import java.net.CookieHandler;

public class CommandPromptApp {
    private CommandPromptApp() {

    }

    public static void run() {
        CommandPrompt commandPrompt = new CommandPrompt("CSD");

        commandPrompt.run();

    }
}
