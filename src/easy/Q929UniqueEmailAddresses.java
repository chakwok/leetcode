package easy;

import java.util.HashSet;

public class Q929UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>(emails.length);

        for (String email: emails) {
            int split = email.indexOf('@');
            String local = email.substring(0, split);
            String domain = email.substring(split);


            if (local.contains("+")) {
                local = local.substring(0, local.indexOf("+"));
            }
            local = local.replaceAll("\\.", "");


            uniqueEmails.add(local + domain);
        }

        return uniqueEmails.size();
    }
}
