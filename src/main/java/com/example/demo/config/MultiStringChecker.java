package com.example.demo.config;

public class MultiStringChecker {
    /**
     * Multiple String checker function SQL문의 in구문 처럼
     * @param s
     * @return
     */
    public static StrChecker str(String s) {
        return new StrChecker(s);
    }

    public static class StrChecker {
        private final String value;

        public StrChecker(String value) {
            this.value = value;
        }

        public boolean in(String ... values) {
            for (String v : values) {
                if (v.equals(value)) return true;
            }
            return false;
        }

        public boolean notIn(String ... values) {
            for (String v : values) {
                if (v.equals(value)) return false;
            }
            return true;
        }
    }
}