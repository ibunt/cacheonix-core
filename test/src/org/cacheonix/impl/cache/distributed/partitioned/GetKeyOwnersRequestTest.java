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

import java.io.IOException;

import org.cacheonix.TestUtils;
import org.cacheonix.impl.net.serializer.Serializer;
import org.cacheonix.impl.net.serializer.SerializerFactory;
import junit.framework.TestCase;

/**
 * Tester for GetKeyOwnersRequest.
 */
public class GetKeyOwnersRequestTest extends TestCase {

   private GetKeyOwnersRequest request = null;

   private static final String TEST_CACHE = "test.cache";


   public void testToString() throws Exception {

      assertNotNull(request.toString());

   }


   public void testSerializeDeserialize() throws IOException, ClassNotFoundException {

      request.setSender(TestUtils.createTestAddress());
      final Serializer ser = SerializerFactory.getInstance().getSerializer(Serializer.TYPE_JAVA);
      final GetKeyOwnersRequest newRequest = (GetKeyOwnersRequest) ser.deserialize(ser.serialize(request));
      assertEquals(request, newRequest);
      assertEquals(TEST_CACHE, newRequest.getCacheName());
   }


   public void testDefaultConstructor() {

      assertNotNull(new GetKeyOwnerRequest().toString());
   }


   protected void setUp() throws Exception {

      super.setUp();
      request = new GetKeyOwnersRequest(TEST_CACHE);
   }
}
