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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class that evaluate typical regular expressions
 * @author Víctor Rodríguez
 */

public class JRegex {
    
    public final static int MIN_PORT_VALUE = 0;
    public final static int MAX_PORT_VALUE = 65535;
    
    public static boolean isEmail(String value){
        return findRegex(EnumRegex.EMAIL_PAT.getRegex(), value);
    }
    
    public static boolean isURL(String value){
        return findRegex(EnumRegex.URL_PAT.getRegex(), value);
    }
    
    public static boolean isPortNumber(int value){
        return value >= MIN_PORT_VALUE && value <= MAX_PORT_VALUE;
    }
    
    public static boolean isPortNumber(String value){
        if (findRegex(EnumRegex.PORT_NUMBER_PAT.getRegex(), value))
            return isPortNumber(value+"");
        else
            return false;
    }

    /**
     * Determines if String is a number with/without sign
     * @param value String to evaluate
     * @return
     * <strong>true: </strong> If String is a un fixed number
     * <strong>false: </strong> If String is not a un fixed number
     */
    public static boolean isInteger(String value){
        return findRegex(EnumRegex.INTEGER_PAT.getRegex(), value);
    }

    /**
     * Determines if String is a float number with/without sign or has/hasn't decimal part
     * @param value String to evaluate
     * @return
     * <strong>true: </strong> if String is a float number with/without sign or has/hasn't decimal part
     * <strong>false: </strong> if String is not a float number with/without sign or has/hasn't decimal part
     */
    public static boolean isNumeric(String value){
        return findRegex(EnumRegex.NUMERIC_PAT.getRegex(), value);
    }

    /**
     * Determines if String have match to the regex
     * @param regex Regex to evaluate on String value
     * @param value String to evaluate
     * @return
     * <strong>true: </strong> if String match with the regex
     * <strong>false: </strong> if String not match with the regex
     */
    public static boolean findRegex(String regex, String value){
        return regexEvaluator(regex, value).find();
    }

    /**
     * Extract all strings that match with the expression
     * @param regex Regex to evaluate on the String value
     * @param value String to evaluate
     * @return
     * <strong>List: </strong> All the substrings that coincided with the regex.
     * <strong>null: </strong> If no substring coincided with the regex.
     */
    public static List<String> extractRegex(String regex, String value){
        Matcher m = regexEvaluator(regex, value);
        List<String> result = null;

        if(m.find()){
            result = new ArrayList<>();
            for(int i=0; i<m.groupCount(); i++)
                result.add(m.group(i));
        }
        return result;
    }

    /**
     * Evaluate regex on the String value
     * @param regex Regex to evaluate on the string
     * @param value String to evaluate
     * @return
     * <strong>Matcher: </strong> Matcher that match with the new pattern
     * <strong>null: </strong> If the String value not matched with the pattern
     */
    private static Matcher regexEvaluator(String regex, String value){
        return Pattern.compile(regex).matcher(value);
    }

}