package net.kineticdevelopment.arcana.common.network;

import net.kineticdevelopment.arcana.core.Main;
import net.kineticdevelopment.arcana.core.research.ResearchEntry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Connection{
	
	public static SimpleNetworkWrapper network;
	private static int id = 0;
	
	public static void init(){
		network = NetworkRegistry.INSTANCE.newSimpleChannel(Main.MODID);
		
		network.registerMessage(PktSyncBooksHandler.class, PktSyncBooks.class, id++, Side.CLIENT);
		network.registerMessage(PktTryAdvanceHandler.class, PktTryAdvance.class, id++, Side.SERVER);
		network.registerMessage(PktAdvanceHandler.class, PktAdvanceResearch.class, id++, Side.CLIENT);
		network.registerMessage(PktCompleteHandler.class, PktCompleteResearch.class, id++, Side.CLIENT);
		network.registerMessage(PktResetHandler.class, PktResetResearch.class, id++, Side.CLIENT);
	}
	
	public static void sendTryAdvance(ResearchEntry entry){
		network.sendToServer(new PktTryAdvance(entry.key()));
	}
	
	public static void sendAdvance(ResearchEntry entry, EntityPlayerMP player){
		network.sendTo(new PktAdvanceResearch(entry.key()), player);
	}
	
	public static void sendReset(ResearchEntry entry, EntityPlayerMP player){
		network.sendTo(new PktResetResearch(entry.key()), player);
	}
	
	public static void sendComplete(ResearchEntry entry, EntityPlayerMP player){
		network.sendTo(new PktCompleteResearch(entry.key()), player);
	}
}