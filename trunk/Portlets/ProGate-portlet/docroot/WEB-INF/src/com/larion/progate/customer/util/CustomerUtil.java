package com.larion.progate.customer.util;

public class CustomerUtil {
	
	 /**
     * Truncate word string when word string is too long
     *
     * @param   source the <Code>String</Code> object is truncated
     * @param   maxLength the <Code>int</Code> object is maximum length of word string after truncated
     * @param   ect the <Code>String</Code> object which replaced for truncated words.
     *
     * @return  the new <Code>String</Code> object after truncated
     */
    public static String truncate(String source, int maxLength, String etc) {
      if ( (source == null) || (source.length() == 0) || (source.length() <= maxLength )) {
          return source;
      }
      return source.substring(0, maxLength).concat(etc);
    }


}
