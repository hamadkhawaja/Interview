/**
 * Created by Hamad on 8/26/2016.
 */

import org.junit.Assert;
import org.junit.Test;

public class PermuteTest {
    @Test
    public void allPermutations() {

        Assert.assertEquals(Permute.allPermutations("abc").toString(), "[abc, bac, bca, acb, cab, cba]");
    }
}
