/*
 * Cacheonix Systems licenses this file to You under the LGPL 2.1
 * (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.cacheonix.org/products/cacheonix/license-lgpl-2.1.htm
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cacheonix.impl.cache.distributed.partitioned;

import org.cacheonix.TestUtils;
import org.cacheonix.impl.net.processor.Router;
import junit.framework.TestCase;

/**
 * Tester for DistributedPrefetchElementUpdater.
 */
public final class DistributedPrefetchElementUpdaterTest extends TestCase {


   private static final String TEST_CACHE_NAME = "test.cache.name";

   private DistributedPrefetchElementUpdater distributedPrefetchElementUpdater;


   public void testToString() throws Exception {

      assertNotNull(distributedPrefetchElementUpdater.toString());
   }


   public void setUp() throws Exception {

      super.setUp();

      final Router router = new Router(TestUtils.createTestAddress(1));
      distributedPrefetchElementUpdater = new DistributedPrefetchElementUpdater(router, TEST_CACHE_NAME);
   }


   public void tearDown() throws Exception {

      super.tearDown();

      distributedPrefetchElementUpdater = null;
   }
}
