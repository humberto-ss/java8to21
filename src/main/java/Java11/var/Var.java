package Java11.var;

import org.junit.Assert;
import org.junit.Test;

public class Var {

    @Test
    public void simpleUse(){
        var integerObject = Integer.valueOf(1);
        var integerPrimitive = 9;
        var shortValue = Short.parseShort(String.valueOf(integerPrimitive));

        Assert.assertTrue(integerObject instanceof Integer);
    }
}
