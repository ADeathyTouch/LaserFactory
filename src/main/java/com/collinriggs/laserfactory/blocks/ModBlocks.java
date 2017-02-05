package com.collinriggs.laserfactory.blocks;

import static net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;
import static net.minecraftforge.fml.common.registry.GameRegistry.registerTileEntity;

import com.collinriggs.laserfactory.blocks.lasers.energy.BlockLesserEnergyLaser;
import com.collinriggs.laserfactory.blocks.lasers.energy.tile.TileEntityEnergyLaser;
import com.collinriggs.laserfactory.blocks.lasers.energy.tile.EnergyLaserTESR;
import com.collinriggs.laserfactory.blocks.lasers.energy.tile.TileEntityLesserEnergyLaser;
import com.collinriggs.laserfactory.blocks.misc.BlockGlowingLapis;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	//Lasers
	public static Block lesserEnergyLaser;
	
	//Machines
	
	
	//Misc
	public static Block glowingLapis;	
	
	public static void registerBlocks() {
		lesserEnergyLaser = new BlockLesserEnergyLaser();
		
		glowingLapis = new BlockGlowingLapis();
		
		registerBlock(lesserEnergyLaser);
		
		registerBlock(glowingLapis);
	}
	
	public static void registerRenders() {
		registerRender(lesserEnergyLaser);
		
		registerRender(glowingLapis);
		
		bindTileEntitySpecialRenderer(TileEntityLesserEnergyLaser.class, new EnergyLaserTESR());
	}
	
	public static void registerTileEntities() {
		registerTileEntity(TileEntityEnergyLaser.class, "tile_entity_lesser_energy_laser");
	}
	
	private static void registerBlock(Block block) {
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block), block.getRegistryName());
	}
	
	private static void registerRender(Block block) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	}
	
}
