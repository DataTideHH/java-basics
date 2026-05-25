import java.util.Optional;

public class SubnetCalculator {
    private record Calculation(
            String inputIp,
            int prefix,
            String subnetMask,
            String wildcardMask,
            String networkAddress,
            String broadcastAddress,
            long totalAddresses,
            long usableHosts,
            String firstUsableHost,
            String lastUsableHost,
            String note
    ) {
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            printUsage();
            System.exit(1);
        }

        Optional<Calculation> result = calculate(args[0]);

        if (result.isEmpty()) {
            System.err.println("Error: invalid input.");
            System.err.println("Expected format: IPv4/CIDR, for example 192.168.10.42/24");
            System.exit(1);
        }

        printResult(result.get());
    }

    private static void printUsage() {
        System.out.println("IPv4 Subnet Calculator");
        System.out.println();
        System.out.println("Usage:");
        System.out.println("  java -cp out SubnetCalculator <IPv4/CIDR>");
        System.out.println();
        System.out.println("Examples:");
        System.out.println("  java -cp out SubnetCalculator 192.168.10.42/24");
        System.out.println("  java -cp out SubnetCalculator 10.0.0.5/30");
        System.out.println("  java -cp out SubnetCalculator 172.16.1.1/16");
    }

    private static void printResult(Calculation result) {
        System.out.println("Input IP:          " + result.inputIp());
        System.out.println("CIDR prefix:       /" + result.prefix());
        System.out.println("Subnet mask:       " + result.subnetMask());
        System.out.println("Wildcard mask:     " + result.wildcardMask());
        System.out.println("Network address:   " + result.networkAddress());
        System.out.println("Broadcast address: " + result.broadcastAddress());
        System.out.println("Total addresses:   " + result.totalAddresses());
        System.out.println("Usable hosts:      " + result.usableHosts());
        System.out.println("First usable host: " + result.firstUsableHost());
        System.out.println("Last usable host:  " + result.lastUsableHost());
        System.out.println("Note:              " + result.note());
    }

    private static Optional<Calculation> calculate(String cidr) {
        int slashPosition = cidr.indexOf('/');

        if (slashPosition < 0) {
            return Optional.empty();
        }

        String ipText = cidr.substring(0, slashPosition);
        String prefixText = cidr.substring(slashPosition + 1);

        Optional<Long> ip = parseIpv4(ipText);
        Optional<Integer> prefix = parsePrefix(prefixText);

        if (ip.isEmpty() || prefix.isEmpty()) {
            return Optional.empty();
        }

        long mask = prefixToMask(prefix.get());
        long wildcard = (~mask) & 0xFFFFFFFFL;
        long network = ip.get() & mask;
        long broadcast = network | wildcard;
        long totalAddresses = 1L << (32 - prefix.get());

        long usableHosts;
        long firstUsable;
        long lastUsable;
        String note;

        if (prefix.get() <= 30) {
            usableHosts = totalAddresses - 2;
            firstUsable = network + 1;
            lastUsable = broadcast - 1;
            note = "Standard subnet with network and broadcast addresses excluded.";
        } else if (prefix.get() == 31) {
            usableHosts = 2;
            firstUsable = network;
            lastUsable = broadcast;
            note = "/31 subnet: both addresses are usable for point-to-point links.";
        } else {
            usableHosts = 1;
            firstUsable = network;
            lastUsable = network;
            note = "/32 host route: single usable address.";
        }

        return Optional.of(new Calculation(
                ipText,
                prefix.get(),
                toIpv4(mask),
                toIpv4(wildcard),
                toIpv4(network),
                toIpv4(broadcast),
                totalAddresses,
                usableHosts,
                toIpv4(firstUsable),
                toIpv4(lastUsable),
                note
        ));
    }

    private static Optional<Integer> parsePrefix(String prefixText) {
        try {
            int prefix = Integer.parseInt(prefixText);

            if (prefix < 0 || prefix > 32) {
                return Optional.empty();
            }

            return Optional.of(prefix);
        } catch (NumberFormatException error) {
            return Optional.empty();
        }
    }

    private static Optional<Long> parseIpv4(String ipText) {
        String[] parts = ipText.split("\\.", -1);

        if (parts.length != 4) {
            return Optional.empty();
        }

        long result = 0;

        for (String part : parts) {
            try {
                int octet = Integer.parseInt(part);

                if (octet < 0 || octet > 255) {
                    return Optional.empty();
                }

                result = (result << 8) | octet;
            } catch (NumberFormatException error) {
                return Optional.empty();
            }
        }

        return Optional.of(result);
    }

    private static long prefixToMask(int prefix) {
        if (prefix == 0) {
            return 0;
        }

        return (0xFFFFFFFFL << (32 - prefix)) & 0xFFFFFFFFL;
    }

    private static String toIpv4(long value) {
        return ((value >> 24) & 0xFF) + "."
                + ((value >> 16) & 0xFF) + "."
                + ((value >> 8) & 0xFF) + "."
                + (value & 0xFF);
    }
}
