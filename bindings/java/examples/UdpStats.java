/*
 * Copyright (c) 2006 Hyperic, Inc.
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

import org.hyperic.sigar.*;

/*

 Example showing UDP status.

 Compile the example:
 % javac -classpath sigar-bin/lib/sigar.jar UdpStats.java

 Run the example:
 % java -classpath sigar-bin/lib/sigar.jar:. UdpStats.java
 java: Running

 */

public class UdpStats {

    protected void printUdpStats(final Sigar sigar) {
        try {
            final Udp udp = sigar.getUdp();

            System.out.println("Udp:");
            System.out
                    .println("InDatagrams\tNoPorts\tInErrors\tOutDatagrams\tRcvbufErrors\tSndbufErrors");
            System.out.println(String.format("%d\t%d\t%d\t%d\t%d\t%d",
                    udp.getInPackets(), udp.getInUnknown(), udp.getInErrs(),
                    udp.getOutPackets(), udp.getInBufferErrs(),
                    udp.getOutBufferErrs()));
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }

    protected void printNetStats(final Sigar sigar) {
        try {
            final NetStat netstat = sigar.getNetStat();
            System.out.println("Netstat:");
            System.out
                    .println("Total IN\tTotal OUT\tTCP IN\tTCP OUT\tUDP IN\tUDP OUT");
            System.out
                    .println(String.format("%d\t%d\t%d\t%d\t%d\t%d",
                            netstat.getAllInboundTotal(),
                            netstat.getAllOutboundTotal(),
                            netstat.getTcpInboundTotal(),
                            netstat.getTcpOutboundTotal(),
                            netstat.getUdpInboundTotal(),
                            netstat.getUdpOutboundTotal()));
        } catch (SigarException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SigarException {

        final UdpStats udpStats = new UdpStats();
        final Sigar sigar = new Sigar();

        udpStats.printUdpStats(sigar);
        udpStats.printNetStats(sigar);

        sigar.close();
    }
}
