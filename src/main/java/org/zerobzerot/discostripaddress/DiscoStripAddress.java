package org.zerobzerot.discostripaddress;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public final class DiscoStripAddress extends Plugin implements Listener {

    @EventHandler
    public void onServerKick(ServerKickEvent event) {
        String reason = BaseComponent.toLegacyText(event.getKickReasonComponent());

        reason = reason.replace("\\(\\\\d{1,3}\\.\\\\d{1,3}\\.\\\\d{1,3}.\\\\d{1,3}\\)", "localhost");

        BaseComponent[] reasonComponent = new BaseComponent[] {
                new TextComponent(reason)
        };

        event.setKickReasonComponent(reasonComponent);
    }
}
