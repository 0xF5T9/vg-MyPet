/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2016 Keyle
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

package de.Keyle.MyPet.compat.v1_11_R1.entity.types;

import de.Keyle.MyPet.api.entity.EntitySize;
import de.Keyle.MyPet.api.entity.MyPet;
import net.minecraft.server.v1_11_R1.World;

@EntitySize(width = 0.6F, height = 1.9F)
public class EntityMyStray extends EntityMySkeleton {

    public EntityMyStray(World world, MyPet myPet) {
        super(world, myPet);
    }

    protected String getDeathSound() {
        return "entity.stray.death";
    }

    protected String getHurtSound() {
        return "entity.stray.hurt";
    }

    protected String getLivingSound() {
        return "entity.stray.ambient";
    }

    public void playPetStepSound() {
        makeSound("entity.stray.step", 0.15F, 1.0F);
    }
}