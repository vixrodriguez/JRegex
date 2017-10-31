/**
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * Enumerator that contains all constants that are used for JRegex
 * @author Víctor Rodríguez
 */
enum EnumConst {
    MIN_PORT_NETWORK(0),
    MAX_PORT_NETWORK(65535);
    
    private int value;

    private EnumConst(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
