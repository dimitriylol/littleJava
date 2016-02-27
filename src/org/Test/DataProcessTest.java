package org.Test;

import junit.framework.TestCase;
import org.DataProcess;

/**
 * Created by dmytro on 27.02.16.
 */
public class DataProcessTest extends TestCase {
    public void testProcessing() {
        DataProcess process = new DataProcess();
        final int expected = 24;
        final int actual = process.process(4);
        assertEquals(expected, actual);
    }
}