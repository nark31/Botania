/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Mar 29, 2015, 10:12:55 PM (GMT)]
 */
package vazkii.botania.common.item.relic;

import cpw.mods.fml.relauncher.ReflectionHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import vazkii.botania.common.lib.LibItemNames;
import vazkii.botania.common.lib.LibObfuscation;

public class ItemInfiniteFruit extends ItemRelic {

	public ItemInfiniteFruit() {
		super(LibItemNames.INFINITE_FRUIT);
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack p_77626_1_) {
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_) {
		return EnumAction.eat;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_) {
		if(p_77659_3_.canEat(false) && isRightPlayer(p_77659_3_, p_77659_1_))
			p_77659_3_.setItemInUse(p_77659_1_, getMaxItemUseDuration(p_77659_1_));
		return p_77659_1_;
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityPlayer player, int count) {
		super.onUsingTick(stack, player, count);

		if(count % 5 == 0)
			player.getFoodStats().addStats(1, 0.1F);
		
		if(count == 5)
			if(player.canEat(false))
				ReflectionHelper.setPrivateValue(EntityPlayer.class, player, 20, LibObfuscation.ITEM_IN_USE_COUNT);
	}
	
}
