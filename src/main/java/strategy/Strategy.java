package strategy;

import java.util.Arrays;
import java.util.List;

public class Strategy
{
    public static void main( String[] args )
    {
        List<String> strs = Arrays.asList( "A", "b", "B", "CD", "cD" );
        strs.sort( String.CASE_INSENSITIVE_ORDER );
        System.out.println( strs );

        strs.sort( String.CASE_INSENSITIVE_ORDER.reversed() );
        System.out.println( strs );
    }
}
