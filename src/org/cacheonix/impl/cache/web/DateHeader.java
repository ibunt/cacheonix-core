/*
 * Cacheonix systems licenses this file to You under the LGPL 2.1
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
package org.cacheonix.impl.cache.web;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.cacheonix.impl.net.serializer.Wireable;
import org.cacheonix.impl.net.serializer.WireableBuilder;

import static org.cacheonix.impl.net.serializer.SerializerUtils.readString;
import static org.cacheonix.impl.net.serializer.SerializerUtils.writeString;
import static org.cacheonix.impl.util.StringUtils.isBlank;

/**
 * A date header.
 */
@SuppressWarnings("NegatedConditionalExpression")
public final class DateHeader implements Header {

   public static final WireableBuilder BUILDER = new WireableBuilder() {

      public Wireable create() {

         return new DateHeader();
      }
   };

   /**
    * The name of the header.
    */
   private String name = null;

   /**
    * A time value.
    */
   private long value = 0L;


   public DateHeader() {

   }


   /**
    * Creates a date header.
    *
    * @param name  the name of the header.
    * @param value the time value.
    */
   DateHeader(final String name, final long value) {

      this.value = value;
      this.name = name;
   }


   /**
    * {@inheritDoc}
    */
   public void addToResponse(final HttpServletResponse httpServletResponse) {

      httpServletResponse.addDateHeader(name, value);
   }


   /**
    * {@inheritDoc}
    */
   public boolean containsString(final String s) {

      if (isBlank(s)) {
         return false;
      }

      return Long.toString(value).toLowerCase().contains(s.toLowerCase());
   }


   /**
    * {@inheritDoc}
    */
   public boolean startsWith(final String s) {

      if (isBlank(s)) {
         return false;
      }

      return Long.toString(value).toLowerCase().startsWith(s.toLowerCase());
   }


   /**
    * Returns the name of the header.
    *
    * @return the name of the header.
    */
   String getName() {

      return name;
   }


   /**
    * Returns the time value.
    *
    * @return the time value.
    */
   long getValue() {

      return value;
   }


   /**
    * Returns index of this object in the object registry.
    *
    * @return index of this object in the object registry.
    */
   public int getWireableType() {

      return TYPE_DATE_HEADER;
   }


   /**
    * Writes this wireable object to the wire.
    *
    * @param out data output stream
    * @throws IOException if an I/O error occurred while writing to the wire.
    */
   public void writeWire(final DataOutputStream out) throws IOException {

      writeString(name, out);
      out.writeLong(value);
   }


   /**
    * Reads this wireable object from the stream.
    *
    * @param in a binary data input
    * @throws IOException if an I/O error occurred while writing to the wire.
    */
   public void readWire(final DataInputStream in) throws IOException {

      name = readString(in);
      value = in.readLong();
   }


   public boolean equals(final Object o) {

      if (this == o) {
         return true;
      }
      if (o == null || !o.getClass().equals(getClass())) {
         return false;
      }

      final DateHeader that = (DateHeader) o;

      if (value != that.value) {
         return false;
      }
      return !(name != null ? !name.equals(that.name) : that.name != null);

   }


   public int hashCode() {

      int result = name != null ? name.hashCode() : 0;
      result = 31 * result + (int) (value ^ value >>> 32);
      return result;
   }


   public String toString() {

      return "DateHeader{" +
              "name='" + name + '\'' +
              ", value=" + value +
              '}';
   }
}
