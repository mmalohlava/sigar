/*
 * Copyright (c) 2007-2008 Hyperic, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hyperic.sigar.test;

import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarNotImplementedException;
import org.hyperic.sigar.SigarPermissionDeniedException;
import org.hyperic.sigar.Tcp;
import org.hyperic.sigar.Udp;

public class TestUdpStat extends SigarTestCase {

    public TestUdpStat(String name) {
        super(name);
    }

    public void testCreate() throws Exception {
        Sigar sigar = getSigar();
        Udp udp;
        
        try {
            udp = sigar.getUdp();
        } catch (SigarNotImplementedException e) {
            return;
        } catch (SigarPermissionDeniedException e) {
            return;
        }

        traceln("");        
        assertValidFieldTrace("InPackets", udp.getInPackets());
        assertValidFieldTrace("OutPackets", udp.getOutPackets());
        assertValidFieldTrace("InErrs", udp.getInErrs());
        assertValidFieldTrace("InUnknown", udp.getInUnknown());
        
    }
}
