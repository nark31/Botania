/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Nov 17, 2014, 6:05:18 PM (GMT)]
 */
package vazkii.botania.common.block.decor;

import vazkii.botania.client.lib.LibResources;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public interface IFloatingFlower {

	public ItemStack getDisplayStack();

	public IslandType getIslandType();
	
	public void setIslandType(IslandType type);

	public static enum IslandType {
		GRASS(LibResources.MODEL_MINI_ISLAND),
		PODZOL(LibResources.MODEL_MINI_ISLAND_PODZOL), 
		MYCEL(LibResources.MODEL_MINI_ISLAND_MYCEL), 
		SNOW(LibResources.MODEL_MINI_ISLAND_SNOW);
		
		private IslandType(String s) {
			res = new ResourceLocation(s);
		}
		
		private final ResourceLocation res;
		
		public static IslandType ofType(String typeStr) {
			for(IslandType type : IslandType.class.getEnumConstants())
				if(type.toString().equals(typeStr))
					return type;
			
			return GRASS;
		}
		
		public ResourceLocation getResource() {
			return res;
		}
		
	}
	
}
