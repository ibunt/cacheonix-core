package org.cacheonix;

import junit.framework.TestCase;

/**
 * A tester for {@link NotSubscribedException}.
 */
public final class NotSubscribedExceptionTest extends TestCase {


   private static final String TEST_MESSAGE = "Test message";

   private NotSubscribedException exception;


   public void testToString() throws Exception {

      assertNotNull(exception.toString());
   }


   public void testGetMessage() throws Exception {

      assertTrue(exception.getMessage().endsWith(TEST_MESSAGE));
   }


   public void setUp() throws Exception {

      super.setUp();

      exception = new NotSubscribedException(TEST_MESSAGE);
   }


   public void tearDown() throws Exception {

      exception = null;

      super.tearDown();
   }


   public String toString() {

      return "NotSubscribedExceptionTest{" +
              "exception=" + exception +
              '}';
   }
}