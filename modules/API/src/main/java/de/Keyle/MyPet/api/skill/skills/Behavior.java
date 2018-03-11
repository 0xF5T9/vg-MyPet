/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2018 Keyle
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

package de.Keyle.MyPet.api.skill.skills;

import de.Keyle.MyPet.api.skill.ActiveSkill;
import de.Keyle.MyPet.api.skill.SkillName;
import de.Keyle.MyPet.api.skill.skilltree.Skill;
import de.Keyle.MyPet.api.util.JsonStorage;
import de.Keyle.MyPet.api.util.Scheduler;

@SkillName(value = "Behavior", translationNode = "Name.Skill.Behavior")
public interface Behavior extends Skill, Scheduler, JsonStorage, ActiveSkill {
    enum BehaviorMode {
        Normal, Friendly, Aggressive, Raid, Farm, Duel
    }

    void setBehavior(BehaviorMode mode);

    void enableBehavior(BehaviorMode mode);

    void disableBehavior(BehaviorMode mode);

    BehaviorMode getBehavior();
}