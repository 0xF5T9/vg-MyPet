/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2020 Keyle
 * MyPet is licensed under the GNU Lesser General Public License.
 *
 * MyPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MyPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.compat.v1_17_R1.entity.types;

import de.Keyle.MyPet.api.Configuration;
import de.Keyle.MyPet.api.entity.EntitySize;
import de.Keyle.MyPet.api.entity.MyPet;
import de.Keyle.MyPet.api.entity.types.MyCow;
import de.Keyle.MyPet.api.entity.types.MyGoat;
import de.Keyle.MyPet.compat.v1_17_R1.entity.EntityMyPet;
import net.minecraft.network.syncher.DataWatcher;
import net.minecraft.network.syncher.DataWatcherObject;
import net.minecraft.network.syncher.DataWatcherRegistry;
import net.minecraft.world.EnumHand;
import net.minecraft.world.EnumInteractionResult;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.World;

@EntitySize(width = 0.7F, height = 1.3F)
public class EntityMyGoat extends EntityMyPet {

    private static final DataWatcherObject<Boolean> AGE_WATCHER = DataWatcher.a(EntityMyGoat.class, DataWatcherRegistry.i);

    public EntityMyGoat(World world, MyPet myPet) {
        super(world, myPet);
    }

    @Override
    protected String getDeathSound() {
        return "entity.goat.death";
    }

    @Override
    protected String getHurtSound() {
        return "entity.goat.hurt";
    }

    @Override
    protected String getLivingSound() {
        return "entity.goat.ambient";
    }

    @Override
    public EnumInteractionResult handlePlayerInteraction(EntityHuman entityhuman, EnumHand enumhand, ItemStack itemStack) {
        if (super.handlePlayerInteraction(entityhuman, enumhand, itemStack).a()) {
            return EnumInteractionResult.b;
        }

        if (getOwner().equals(entityhuman) && itemStack != null && canUseItem()) {
            if (itemStack.getItem() == Items.nW && Configuration.MyPet.Goat.CAN_GIVE_MILK) {
                ItemStack milkBucket = new ItemStack(Items.oc);

                entityhuman.getInventory().setItem(entityhuman.getInventory().k, milkBucket);
                return EnumInteractionResult.b;
            } else if (Configuration.MyPet.Goat.GROW_UP_ITEM.compare(itemStack) && getMyPet().isBaby() && getOwner().getPlayer().isSneaking()) {
                if (itemStack != ItemStack.b && !entityhuman.getAbilities().d) {
                    itemStack.subtract(1);
                    if (itemStack.getCount() <= 0) {
                        entityhuman.getInventory().setItem(entityhuman.getInventory().k, ItemStack.b);
                    }
                }
                getMyPet().setBaby(false);
                return EnumInteractionResult.b;
            }
        }
        return EnumInteractionResult.d;
    }
    @Override
    protected void initDatawatcher() {
        super.initDatawatcher();
        getDataWatcher().register(AGE_WATCHER, false);
    }

    @Override
    public void updateVisuals() {
        this.getDataWatcher().set(AGE_WATCHER, getMyPet().isBaby());
    }

    @Override
    public void playPetStepSound() {
        makeSound("entity.goat.step", 0.15F, 1.0F);
    }

    @Override
    public MyGoat getMyPet() {
        return (MyGoat) myPet;
    }
}
