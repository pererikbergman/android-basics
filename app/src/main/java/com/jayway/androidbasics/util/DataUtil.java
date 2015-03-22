package com.jayway.androidbasics.util;

import com.jayway.androidbasics.model.Data;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class DataUtil {
    public static Comparator<Data>   NameComparator = new NameComparator();
    public static Comparator<Data>   ValueComparator = new ValueComparator();

    private static class NameComparator implements Comparator<Data> {
        private final Collator deCollator;

        private NameComparator() {
            deCollator = Collator.getInstance(new Locale("se"));
        }

        @Override
        public int compare(Data lhs, Data rhs) {
            String id1 = lhs.getName();
            String id2 = rhs.getName();

            return id1.compareTo(id2);
        }
    }

    private static class ValueComparator implements Comparator<Data> {
        private final Collator deCollator;

        private ValueComparator() {
            deCollator = Collator.getInstance(new Locale("se"));
        }

        @Override
        public int compare(Data lhs, Data rhs) {
            Integer id1 = lhs.getValue();
            Integer id2 = rhs.getValue();

            return id1.compareTo(id2);
        }
    }
}