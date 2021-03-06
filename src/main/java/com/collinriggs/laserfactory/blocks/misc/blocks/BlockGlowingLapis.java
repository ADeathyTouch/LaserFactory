package com.collinriggs.laserfactory.blocks.misc.blocks;

import java.util.Random;

import com.collinriggs.laserfactory.LaserFactory;
import com.collinriggs.laserfactory.items.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.MathHelper;

public class BlockGlowingLapis extends Block {

	public BlockGlowingLapis() {
		super(Material.ROCK);
		
		this.setUnlocalizedName("glowingLapisBlock");
		this.setRegistryName("glowinglapis");
		this.setCreativeTab(LaserFactory.CREATIVE_TAB);
		this.setHarvestLevel("pickaxe", 1);
		this.setLightLevel(0.5F);
		this.setHardness(0.5F);
		this.setResistance(0.1F);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return ModItems.glowingLapisShard;
	}
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
        return MathHelper.clamp(this.quantityDropped(random) + random.nextInt(fortune + 1), 1, 4);
    }

    @Override
    public int quantityDropped(Random random) {
        return 2 + random.nextInt(3);
    }

}
