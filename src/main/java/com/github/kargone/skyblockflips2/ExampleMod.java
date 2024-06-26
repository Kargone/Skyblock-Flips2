package com.github.kargone.skyblockflips2;

import net.minecraft.init.Blocks;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.IOException;

@Mod(modid = "skyblockflips", useMetadata=true)
public class ExampleMod {
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onChat(ClientChatReceivedEvent event) {
        String message = event.message.getUnformattedText();
        if (message.contains("[Bazaar]") || message.contains("You sold") ||
                message.contains("created a BIN auction") || message.contains("You collected") ||
                message.contains("You cancelled") || message.contains("You Supercrafted") ||
                message.contains("[Auction]") || message.contains("You purchased")) {
            HttpClientExample myPostRequest = new HttpClientExample();
            try {
                String result = myPostRequest.sendPOST("http://localhost:8000", message);
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
