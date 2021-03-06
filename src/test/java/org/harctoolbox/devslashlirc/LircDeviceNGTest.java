/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.harctoolbox.devslashlirc;

import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author bengt
 */
public class LircDeviceNGTest {
    private static LircDevice instance;
    public LircDeviceNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws LircDeviceException {
        LircHardware.loadLibrary();
        Mode2LircDevice thing = new Mode2LircDevice();
        assertFalse(thing.isValid());
        thing.open();
        assertTrue(thing.isValid());
        instance = thing;
    }

    @AfterClass
    public static void tearDownClass() throws Exception, Throwable {
        instance.close();
        assertFalse(instance.isValid());
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getVersion method, of class LircDevice.
     */
    @Test
    public void testGetVersion() {
        System.out.println("getVersion");

        String result = instance.getVersion();
        assertEquals(result, "LircDevice 0.1.0");
    }

    /**
     * Test of setTransmitterMask method, of class LircDevice.
     * @throws LircDeviceException
     */
    @Test
    public void testSetTransmitterMask() throws LircDeviceException {
        System.out.println("setTransmitterMask");
        int mask = 1;
        try {
            instance.setTransmitterMask(mask);
        } catch (NotSupportedException | NonExistentTransmitterException ex) {
            Logger.getLogger(LircDeviceNGTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of getNumberTransmitters method, of class LircDevice.
     */
    @Test
    public void testGetNumberTransmitters() {
        System.out.println("getNumberTransmitters");
        int expResult = 0;
        int result = instance.getNumberTransmitters();
        assertEquals(result, expResult);
    }

    /**
     * Test of canSend method, of class LircDevice.
     */
    @Test
    public void testCanSend() {
        System.out.println("canSend");
        boolean expResult = true;
        boolean result = instance.canSend();
        assertEquals(result, expResult);
    }

    /**
     * Test of canSetTransmitterMask method, of class LircDevice.
     */
    @Test
    public void testCanSetTransmitterMask() {
        System.out.println("canSetTransmitterMask");
        boolean expResult = true;
        boolean result = instance.canSetTransmitterMask();
        assertEquals(result, expResult);
    }

    /**
     * Test of canRec method, of class LircDevice.
     */
    @Test
    public void testCanRec() {
        System.out.println("canRec");
        boolean expResult = true;
        boolean result = instance.canRec();
        assertEquals(result, expResult);
    }

    /**
     * Test of toString method, of class LircDevice.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "mode2  setCarr. send rec. setTM #xmtrs=0";
        String result = instance.toString();
        assertEquals(result, expResult);
    }
}
