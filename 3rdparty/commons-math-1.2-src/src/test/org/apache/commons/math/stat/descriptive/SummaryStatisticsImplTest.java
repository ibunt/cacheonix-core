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
package org.apache.commons.math.stat.descriptive;


import junit.framework.Test;
import junit.framework.TestSuite;
/**
 * Test cases for the {@link SummaryStatisticsImpl} class.
 * @deprecated - to be removed in 2.0 with SummaryStatisticsImpl
 * @version $Revision: 608839 $ $Date: 2008-01-04 06:49:14 -0700 (Fri, 04 Jan 2008) $
 */

public final class SummaryStatisticsImplTest extends SummaryStatisticsAbstractTest {

    public SummaryStatisticsImplTest(String name) {
        super(name);
    }

    public static Test suite() {
        TestSuite suite = new TestSuite(SummaryStatisticsImplTest.class);
        suite.setName("SummaryStatisticsImpl Tests");
        return suite;
    }

    protected SummaryStatistics createSummaryStatistics() {
        return new SummaryStatisticsImpl();
    }
}