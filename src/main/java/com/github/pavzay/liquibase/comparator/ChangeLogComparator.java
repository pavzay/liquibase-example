package com.github.pavzay.liquibase.comparator;

import java.util.Comparator;

/**
 * Compare changelog files by their path name without "schema" and "data" folders.
 */
public class ChangeLogComparator implements Comparator<String> {

    public int compare(String o1, String o2) {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;
        if (o1.equals(o2)) return 0;

        String changelog1 = o1.replace("schema", "").replace("data", "");
        String changelog2 = o2.replace("schema", "").replace("data", "");
        return changelog1.compareTo(changelog2);
    }
}
