package org.realityforge.webtack.model.tools.util;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nonnull;

public final class StringUtil
{
  @Nonnull
  private static final Map<Character, String> CHAR_TO_HTML_ENTITIES_MAP = new HashMap<>();

  static
  {
    // Special characters for HTML
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0026', "&amp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u003C', "&lt;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u003E', "&gt;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0022', "&quot;" );

    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0152', "&OElig;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0153', "&oelig;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0160', "&Scaron;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0161', "&scaron;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0178', "&Yuml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u02C6', "&circ;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u02DC', "&tilde;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2002', "&ensp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2003', "&emsp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2009', "&thinsp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u200C', "&zwnj;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u200D', "&zwj;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u200E', "&lrm;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u200F', "&rlm;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2013', "&ndash;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2014', "&mdash;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2018', "&lsquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2019', "&rsquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u201A', "&sbquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u201C', "&ldquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u201D', "&rdquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u201E', "&bdquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2020', "&dagger;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2021', "&Dagger;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2030', "&permil;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2039', "&lsaquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u203A', "&rsaquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u20AC', "&euro;" );

    // Character entity references for ISO 8859-1 characters
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A0', "&nbsp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A1', "&iexcl;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A2', "&cent;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A3', "&pound;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A4', "&curren;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A5', "&yen;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A6', "&brvbar;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A7', "&sect;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A8', "&uml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00A9', "&copy;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00AA', "&ordf;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00AB', "&laquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00AC', "&not;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00AD', "&shy;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00AE', "&reg;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00AF', "&macr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B0', "&deg;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B1', "&plusmn;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B2', "&sup2;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B3', "&sup3;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B4', "&acute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B5', "&micro;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B6', "&para;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B7', "&middot;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B8', "&cedil;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00B9', "&sup1;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00BA', "&ordm;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00BB', "&raquo;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00BC', "&frac14;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00BD', "&frac12;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00BE', "&frac34;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00BF', "&iquest;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C0', "&Agrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C1', "&Aacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C2', "&Acirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C3', "&Atilde;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C4', "&Auml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C5', "&Aring;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C6', "&AElig;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C7', "&Ccedil;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C8', "&Egrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00C9', "&Eacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00CA', "&Ecirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00CB', "&Euml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00CC', "&Igrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00CD', "&Iacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00CE', "&Icirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00CF', "&Iuml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D0', "&ETH;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D1', "&Ntilde;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D2', "&Ograve;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D3', "&Oacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D4', "&Ocirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D5', "&Otilde;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D6', "&Ouml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D7', "&times;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D8', "&Oslash;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00D9', "&Ugrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00DA', "&Uacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00DB', "&Ucirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00DC', "&Uuml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00DD', "&Yacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00DE', "&THORN;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00DF', "&szlig;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E0', "&agrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E1', "&aacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E2', "&acirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E3', "&atilde;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E4', "&auml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E5', "&aring;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E6', "&aelig;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E7', "&ccedil;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E8', "&egrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00E9', "&eacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00EA', "&ecirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00EB', "&euml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00EC', "&igrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00ED', "&iacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00EE', "&icirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00EF', "&iuml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F0', "&eth;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F1', "&ntilde;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F2', "&ograve;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F3', "&oacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F4', "&ocirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F5', "&otilde;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F6', "&ouml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F7', "&divide;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F8', "&oslash;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00F9', "&ugrave;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00FA', "&uacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00FB', "&ucirc;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00FC', "&uuml;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00FD', "&yacute;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00FE', "&thorn;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u00FF', "&yuml;" );

    // Mathematical, Greek and Symbolic characters for HTML
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0192', "&fnof;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0391', "&Alpha;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0392', "&Beta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0393', "&Gamma;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0394', "&Delta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0395', "&Epsilon;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0396', "&Zeta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0397', "&Eta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0398', "&Theta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u0399', "&Iota;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u039A', "&Kappa;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u039B', "&Lambda;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u039C', "&Mu;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u039D', "&Nu;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u039E', "&Xi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u039F', "&Omicron;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A0', "&Pi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A1', "&Rho;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A3', "&Sigma;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A4', "&Tau;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A5', "&Upsilon;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A6', "&Phi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A7', "&Chi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A8', "&Psi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03A9', "&Omega;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B1', "&alpha;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B2', "&beta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B3', "&gamma;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B4', "&delta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B5', "&epsilon;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B6', "&zeta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B7', "&eta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B8', "&theta;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03B9', "&iota;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03BA', "&kappa;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03BB', "&lambda;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03BC', "&mu;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03BD', "&nu;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03BE', "&xi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03BF', "&omicron;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C0', "&pi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C1', "&rho;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C2', "&sigmaf;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C3', "&sigma;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C4', "&tau;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C5', "&upsilon;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C6', "&phi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C7', "&chi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C8', "&psi;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03C9', "&omega;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03D1', "&thetasym;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03D2', "&upsih;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u03D6', "&piv;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2022', "&bull;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2026', "&hellip;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2032', "&prime;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2033', "&Prime;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u203E', "&oline;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2044', "&frasl;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2118', "&weierp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2111', "&image;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u211C', "&real;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2122', "&trade;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2135', "&alefsym;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2190', "&larr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2191', "&uarr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2192', "&rarr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2193', "&darr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2194', "&harr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u21B5', "&crarr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u21D0', "&lArr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u21D1', "&uArr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u21D2', "&rArr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u21D3', "&dArr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u21D4', "&hArr;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2200', "&forall;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2202', "&part;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2203', "&exist;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2205', "&empty;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2207', "&nabla;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2208', "&isin;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2209', "&notin;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u220B', "&ni;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u220F', "&prod;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2211', "&sum;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2212', "&minus;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2217', "&lowast;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u221A', "&radic;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u221D', "&prop;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u221E', "&infin;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2220', "&ang;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2227', "&and;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2228', "&or;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2229', "&cap;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u222A', "&cup;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u222B', "&int;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2234', "&there4;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u223C', "&sim;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2245', "&cong;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2248', "&asymp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2260', "&ne;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2261', "&equiv;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2264', "&le;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2265', "&ge;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2282', "&sub;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2283', "&sup;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2284', "&nsub;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2286', "&sube;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2287', "&supe;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2295', "&oplus;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2297', "&otimes;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u22A5', "&perp;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u22C5', "&sdot;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2308', "&lceil;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2309', "&rceil;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u230A', "&lfloor;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u230B', "&rfloor;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2329', "&lang;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u232A', "&rang;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u25CA', "&loz;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2660', "&spades;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2663', "&clubs;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2665', "&hearts;" );
    CHAR_TO_HTML_ENTITIES_MAP.put( '\u2666', "&diams;" );
  }

  private StringUtil()
  {
  }

  /**
   * Replace any special characters with the equivalent html entities.
   *
   * @param source the input string.
   * @return the output string with special characters replaced with entities.
   */
  @Nonnull
  public static String encodeHtml( @Nonnull final String source )
  {
    StringBuffer output = null;
    final char[] chars = source.toCharArray();
    int lastMatch = -1;

    for ( int i = 0; i < chars.length; i++ )
    {
      final char ch = chars[ i ];
      if ( CHAR_TO_HTML_ENTITIES_MAP.containsKey( ch ) )
      {
        if ( null == output )
        {
          output = new StringBuffer( source.length() );
        }
        final int difference = i - ( lastMatch + 1 );
        if ( difference > 0 )
        {
          output.append( chars, lastMatch + 1, difference );
        }
        output.append( CHAR_TO_HTML_ENTITIES_MAP.get( ch ) );
        lastMatch = i;
      }
    }

    if ( null == output )
    {
      return source;
    }
    else
    {
      final int difference = chars.length - ( lastMatch + 1 );
      if ( difference > 0 )
      {
        output.append( chars, lastMatch + 1, difference );
      }
      return output.toString();
    }
  }
}
