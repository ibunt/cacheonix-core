/*
 * Cacheonix systems licenses this file to You under the LGPL 2.1
 * (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *      http://www.cacheonix.com/products/cacheonix/license-lgpl-2.1.htm
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cacheonix.impl.net.processor;

import org.cacheonix.impl.util.logging.Logger;

/**
 * Command executed by the Processor.
 * <p/>
 *
 * @author <a href="mailto:simeshev@cacheonix.com">Slava Imeshev</a>
 * @since Jan 8, 2010 8:17:22 AM
 */
public abstract class Command {

   /**
    * Logger.
    *
    * @noinspection UNUSED_SYMBOL, UnusedDeclaration
    */
   private static final Logger LOG = Logger.getLogger(Command.class); // NOPMD


   public abstract void execute() throws InterruptedException;
}