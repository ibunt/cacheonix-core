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
package org.cacheonix.impl.net.cluster;

import java.io.IOException;

import org.cacheonix.impl.net.serializer.Serializer;
import org.cacheonix.impl.net.serializer.SerializerFactory;
import org.cacheonix.impl.net.serializer.Wireable;
import junit.framework.TestCase;

/**
 * CleanupMarker Tester.
 *
 * @author simeshev@cacheonix.org
 * @version 1.0
 * @since <pre>04/08/2008</pre>
 */
public final class CleanupMarkerTest extends TestCase {

   private CleanupMarker marker;


   public CleanupMarkerTest(final String name) {

      super(name);
   }


   public void testToString() {

      assertNotNull(marker.toString());
   }


   public void testSerializeDeserialize() throws IOException {

      final Serializer serializer = SerializerFactory.getInstance().getSerializer(Serializer.TYPE_JAVA);
      final byte[] bytes = serializer.serialize(marker);
      assertEquals(marker, serializer.deserialize(bytes));
   }


   public void testDefaultConstructor() {

      assertEquals(Wireable.TYPE_CLUSTER_CLEANUP_MARKER, new CleanupMarker().getWireableType());
   }


   protected void setUp() throws Exception {

      super.setUp();
      marker = new CleanupMarker();
   }


   public String toString() {

      return "CleanupMarkerTest{" +
              "marker=" + marker +
              "} " + super.toString();
   }
}
