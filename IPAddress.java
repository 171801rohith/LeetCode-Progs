// 1108. Defanging an IP Address
// Given a valid (IPv4) IP address, return a defanged version of that IP address.
// A defanged IP address replaces every period "." with "[.]".

// Example 1:
// Input: address = "1.1.1.1"
// Output: "1[.]1[.]1[.]1"

// Example 2:
// Input: address = "255.100.50.0"
// Output: "255[.]100[.]50[.]0"

public class IPAddress {
    public String defangIPaddr(String address) {
        StringBuilder newAddress = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') newAddress.append("[.]");
            else newAddress.append(address.charAt(i));
        }
        return newAddress.toString();
    }
}
