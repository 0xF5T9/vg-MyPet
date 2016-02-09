/*
 * This file is part of MyPet
 *
 * Copyright (C) 2011-2016 Keyle
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

package de.Keyle.MyPet.util.hooks;

import de.Keyle.MyPet.util.hooks.arenas.*;

public class Hooks {
    public static void enable() {
        MagicSpellsHook.findPlugin();
        SkillApi.findPlugin();
        MobArena.findPlugin();
        Minigames.findPlugin();
        PvPArena.findPlugin();
        BattleArena.findPlugin();
        SurvivalGames.findPlugin();
        UltimateSurvivalGames.findPlugin();
        MyHungerGames.findPlugin();
        if (PluginHookManager.isPluginUsable("ProtocolLib")) {
            ProtocolLib.findPlugin();
        }
    }

    public static void disable() {
        PvPChecker.reset();
        EconomyHook.reset();
    }
}
