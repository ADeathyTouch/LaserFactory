package com.collinriggs.laserfactory.proxy;

import com.collinriggs.laserfactory.LaserFactory;
import com.collinriggs.laserfactory.blocks.ModBlocks;
import com.collinriggs.laserfactory.crafting.ModCrafting;
import com.collinriggs.laserfactory.events.EventHandler;
import com.collinriggs.laserfactory.gui.GuiHandler;
import com.collinriggs.laserfactory.items.ModItems;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) {
		ModBlocks.registerBlocks();
		ModBlocks.registerTileEntities();
		
		ModItems.registerItems();
	}
	
	public void init(FMLInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(LaserFactory.instance, new GuiHandler());
		
		ModCrafting.registerRecipes();
	}
	
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
}
