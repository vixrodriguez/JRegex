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

public class JRegex{
    
    /**
     * Determines if String represent a human name; that is, a name composed of only letters. 
     * @param value String to evaluate
     * @return 
     * <strong>true: </strong> If String is a human name. <br/>
     * <strong>false: </strong> If String is not a human name.
     */
    public static boolean isHumanName(String value){
        return checkStr(value, EnumRegex.HUMAN_NAME_PAT);
    }
    
    /**
     * Determines if String represent a e-mail.
     * @param value String to evaluate.
     * @return 
     * <strong>true: </strong> If String is a e-mail. <br/>
     * <strong>false: </strong> If String is not a e-mail.
     */
    public static boolean isEmail(String value){
        return checkStr(value, EnumRegex.EMAIL_PAT);
    }
    
    /**
     * Determines if String represent a URL link
     * @param value String to evaluate
     * @return 
     * <strong>true: </strong> If String corresponds a URL link. <br/>
     * <strong>false: </strong> If String not corresponds a URL link.
     */
    public static boolean isURL(String value){
        return checkStr(value, EnumRegex.URL_PAT);
    }
    
    /**
     * Determines if String match to any port number in a Operative System. <br/>
     * Reminder that the port numbers are range between {@value #MIN_PORT_VALUE} and
     * {@value #MAX_PORT_VALUE}
     * @param value port number to evaluate
     * @return 
     */
    public static boolean isPortNumber(int value){
        int minPort = EnumConst.MIN_PORT_NETWORK.getValue();
        int maxPort = EnumConst.MAX_PORT_NETWORK.getValue();
        return value >= minPort && value <= maxPort;
    }
    
    /**
     * Determines if String match to any port number in a Operative System. <br/>
     * Reminder that the port numbers are range between {@value #MIN_PORT_VALUE} and
     * {@value #MAX_PORT_VALUE}
     * @param value String to evaluate
     * @return 
     */
    public static boolean isPortNumber(String value){
        return (checkStr(value, EnumRegex.PORT_NUMBER_PAT)) ? isPortNumber(value+"") : false;
    }

    /**
     * Determines if String is a number with/without sign.
     * @param value String to evaluate.
     * @return
     * <strong>true: </strong> If String is a un fixed number. <br/>
     * <strong>false: </strong> If String is not a un fixed number.
     */
    public static boolean isInteger(String value){
        return checkStr(value, EnumRegex.INTEGER_PAT);
    }

    /**
     * Determines if String is a float number with/without sign or has/hasn't decimal part.
     * @param value String to evaluate.
     * @return
     * <strong>true: </strong> if String is a float number with/without sign or has/hasn't decimal part. <br/>
     * <strong>false: </strong> if String is not a float number with/without sign or has/hasn't decimal part.
     */
    public static boolean isNumeric(String value){
        return checkStr(value, EnumRegex.NUMERIC_PAT);
    }
    
    /**
     * General method to check if String match to regex
     * @param value String to evaluate
     * @param regex Regex to evaluate on String value
     * @return 
     */
    public static boolean checkStr(String value, EnumRegex regex){
        return findRegex(value, regex.getRegex());
    }

    /**
     * Determines if String have match to the regex
     * @param regex Regex to evaluate on String value
     * @param value String to evaluate
     * @return
     * <strong>true: </strong> if String match with the regex <br/>
     * <strong>false: </strong> if String not match with the regex
     */
    public static boolean findRegex(String regex, String value){
        return regexEvaluator(regex, value).find();
    }

    /**
     * Extract all strings that match with the expression.
     * @param regex Regex to evaluate on the String value.
     * @param value String to evaluate.
     * @return
     * <strong>List: </strong> All the substrings that coincided with the regex. <br/>
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
     * <strong>Matcher: </strong> Matcher that match with the new pattern. <br/>
     * <strong>null: </strong> If the String value not matched with the pattern.
     */
    private static Matcher regexEvaluator(String regex, String value){
        return Pattern.compile(regex).matcher(value);
    }

}