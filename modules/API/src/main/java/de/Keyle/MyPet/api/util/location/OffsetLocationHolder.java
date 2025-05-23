/*
 * This file is part of MyPet
 *
 * Copyright © 2011-2019 Keyle
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

/*
 * This file is part of mypet-api_main
 *
 * Copyright (C) 2011-2016 Keyle
 * mypet-api_main is licensed under the GNU Lesser General Public License.
 *
 * mypet-api_main is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * mypet-api_main is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package de.Keyle.MyPet.api.util.location;

import org.bukkit.Location;

@SuppressWarnings("all")

public class OffsetLocationHolder extends LocationHolder<LocationHolder> {

    private LocationHolder location;
    protected double x;
    protected double y;
    protected double z;

    public OffsetLocationHolder(LocationHolder location, double x, double y, double z) {
        this.location = location;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public Location getLocation() {
        Location clone = location.getLocation().clone();
        clone.add(x, y, z);
        return clone;
    }

    @Override
    public LocationHolder getHolder() {
        return location;
    }

    @Override
    public boolean isValid() {
        return location.isValid();
    }
}