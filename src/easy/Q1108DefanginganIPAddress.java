package easy;

public class Q1108DefanginganIPAddress {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "\\[\\.\\]");
    }
}
