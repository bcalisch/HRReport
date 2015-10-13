package com.evident.helper;


import org.junit.Assert;
import org.junit.Test;

/**
 * Created by benjamin on 10/11/15.
 */
public class OptionsImplTest {

    @Test
    public void testHasOption_OptionExists() throws Exception {
        Options options = new OptionsImpl();
       Assert.assertTrue(options.hasOption("-ts"));
    }

    @Test
    public void testHasOption_OptionExists_totalByRole() throws Exception {
        Options options = new OptionsImpl();
        Assert.assertTrue(options.hasOption("-ts:r"));
    }

    @Test
    public void testHasOption_OptionDoesNotExist() throws Exception {
        Options options = new OptionsImpl();
        Assert.assertFalse(options.hasOption("-ts:ts"));
    }

}