/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cacheonix.impl.util.logging.lf5;

import org.cacheonix.impl.util.logging.spi.ThrowableInformation;

/**
 * A <code>Log4JLogRecord</code> encapsulates the details of your log4j <code>LoggingEvent</code> in a format usable by
 * the <code>LogBrokerMonitor</code>.
 *
 * @author Brent Sprecher
 */

// Contributed by ThoughtWorks Inc.

public final class Log4JLogRecord extends LogRecord {

   //--------------------------------------------------------------------------
   //   Constants:
   //--------------------------------------------------------------------------
   private static final long serialVersionUID = 0L;

   //--------------------------------------------------------------------------
   //   Protected Variables:
   //--------------------------------------------------------------------------

   //--------------------------------------------------------------------------
   //   Private Variables:
   //--------------------------------------------------------------------------

   //--------------------------------------------------------------------------
   //   Constructors:
   //--------------------------------------------------------------------------

   //--------------------------------------------------------------------------
   //   Public Methods:
   //--------------------------------------------------------------------------


   /**
    * Determines which <code>Priority</code> levels will be displayed in colored font when the
    * <code>LogMonitorAppender</code> renders this log message. By default, messages will be colored red if they are of
    * <code>Priority</code> ERROR or FATAL.
    *
    * @return <code>true</code> if the log level is ERROR or FATAL.
    */
   public boolean isSevereLevel() {

      boolean isSevere = false;

      if (LogLevel.ERROR.equals(getLevel()) ||
              LogLevel.FATAL.equals(getLevel())) {
         isSevere = true;
      }

      return isSevere;
   }


   /**
    * Set stack trace information associated with this Log4JLogRecord. When this method is called, the stack trace in a
    * String-based format is made available via the getThrownStackTrace() method.
    *
    * @param throwableInfo An org.cacheonix.impl.util.logging.spi.ThrowableInformation to associate with this
    *                      Log4JLogRecord.
    * @see #getThrownStackTrace()
    */
   public final void setThrownStackTrace(final ThrowableInformation throwableInfo) {

      final String[] stackTraceArray = throwableInfo.getThrowableStrRep();

      final StringBuilder stackTrace = new StringBuilder(100);

      for (int i = 0; i < stackTraceArray.length; i++) {
         final String nextLine = stackTraceArray[i] + '\n';
         stackTrace.append(nextLine);
      }

      _thrownStackTrace = stackTrace.toString();
   }

   //--------------------------------------------------------------------------
   //   Protected Methods:
   //--------------------------------------------------------------------------

   //--------------------------------------------------------------------------
   //   Private Methods:
   //--------------------------------------------------------------------------

   //--------------------------------------------------------------------------
   //   Nested Top-Level Classes or Interfaces:
   //--------------------------------------------------------------------------

}


