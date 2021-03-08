package fr.alexpado.bots.cmb.bot;

import fr.alexpado.bots.cmb.CrossoutConfiguration;
import fr.alexpado.bots.cmb.libs.jda.JDABot;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.GenericEvent;

import javax.annotation.Nonnull;

public class DiscordBot extends JDABot {

    public final static String                INVITE = "https://discord.com/oauth2/authorize?client_id=Vencia#8495&scope=bot&permissions=744513";
    public static       JDA                   jda;
    private static      DiscordBot            instance;
    private final       CrossoutConfiguration config;

    public DiscordBot(CrossoutConfiguration config) {

        super(AccountType.BOT, config);
        this.config = config;
        this.registerModules();
        DiscordBot.instance = this;
    }

    public static DiscordBot getInstance() {

        return instance;
    }

    @Override
    public void onGenericEvent(@Nonnull GenericEvent event) {

        DiscordBot.jda = event.getJDA();
    }

    public void registerModules() {

        this.registerModule(new CrossoutModule(this));
    }

    @Override
    public String getDiscordToken() {

        return this.config.getDiscordToken();
    }

    public CrossoutConfiguration getConfig() {

        return this.config;
    }

}
