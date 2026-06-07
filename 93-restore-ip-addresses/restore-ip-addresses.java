class Solution {

    public List<String> restoreIpAddresses(
            String s) {

        List<String> result =
            new ArrayList<>();

        backtrack(result,
                  "",
                  s,
                  0,
                  0);

        return result;
    }

    private void backtrack(
            List<String> result,
            String current,
            String s,
            int index,
            int parts) {

        if (parts == 4 &&
            index == s.length()) {

            result.add(
                current.substring(
                    0,
                    current.length() - 1));

            return;
        }

        if (parts > 4)
            return;

        for (int len = 1;
             len <= 3 &&
             index + len <= s.length();
             len++) {

            String segment =
                s.substring(index,
                            index + len);

            if ((segment.startsWith("0")
                && segment.length() > 1)
                ||
                Integer.parseInt(segment) > 255)
                continue;

            backtrack(result,
                      current + segment + ".",
                      s,
                      index + len,
                      parts + 1);
        }
    }
}