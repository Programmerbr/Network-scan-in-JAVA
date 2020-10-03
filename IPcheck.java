import com.sun.source.doctree.SystemPropertyTree;

import java.net.*;

public class IPcheck {

    public static void main(String[] args) {

        // Method calling
        userName();
        SysProp();
        IpAddress();

    }
    //System Property pull request

    public static void SysProp (){
        System.out.println("System information: " + System.getProperty("os.name"));
        System.out.println("System version: " + System.getProperty("os.version"));
    }

    // User name scan
    public static void userName() {
        System.out.println("\nUser: " + System.getProperty("user.name"));
    }

    // Get IP Address
    public static void IpAddress() {
        // Local variable
        String call = "IP configuration - Local Area Network\n";

        System.out.println("\n--- Network Information Request ---\n");
        System.out.println (call);

        try {
            System.out.println("Computer Name: " + InetAddress.getLocalHost().getHostName());
            System.out.println("IP Address: " + InetAddress.getLocalHost().getHostAddress());

            // Calling a Method inside other Method
            MacAddress();

            System.out.println("Loopback address: " + InetAddress.getLoopbackAddress());
            System.out.println("network interface: " + NetworkInterface.getNetworkInterfaces());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


// Get MAC Address

    public static void MacAddress() {
        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();

            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address : ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());

        } catch (UnknownHostException e) {

            e.printStackTrace();

        } catch (SocketException e) {

            e.printStackTrace();

        }

    }


// end of the code
}