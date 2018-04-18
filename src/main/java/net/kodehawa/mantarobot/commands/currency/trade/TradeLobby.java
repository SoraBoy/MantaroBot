/*
 * Copyright (C) 2016-2018 David Alejandro Rubio Escares / Kodehawa
 *
 * Mantaro is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * Mantaro is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mantaro.  If not, see http://www.gnu.org/licenses/
 */

package net.kodehawa.mantarobot.commands.currency.trade;

import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.kodehawa.mantarobot.commands.currency.item.Item;
import net.kodehawa.mantarobot.commands.interaction.Lobby;
import net.kodehawa.mantarobot.core.modules.commands.i18n.I18nContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TradeLobby extends Lobby {
    public static final Map<TextChannel, TradeLobby> LOBBYS = new ConcurrentHashMap<>();

    public List<Long> usersTrading = new ArrayList<>();
    public GuildMessageReceivedEvent event;
    public I18nContext language;
    public Item initialItem;
    public long initialCredits;
    public Map<Long, Long> creditMap = new HashMap<>();
    public Map<Long, List<Item>> itemMap = new HashMap<>();

    public TradeLobby(GuildMessageReceivedEvent event, I18nContext languageContext, String guild, String channel, Item initialItem, long initialCredits, long... users) {
        super(guild, channel);

        this.event = event;
        this.language = languageContext;
        this.initialCredits = initialCredits;
        this.initialItem = initialItem;
        for(long user : users) {
            usersTrading.add(user);
        }
    }

    //TODO
    public void startLobby() {

    }

    @Override
    public String toString() {
        return String.format("TradeLobby{%s, (ii %s, ic %s, cm %s, im %s), users:%d, channel:%s}", event.getGuild(),
                initialItem, initialCredits, creditMap, itemMap, usersTrading.size(), getChannel());
    }
}
