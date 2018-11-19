package com.cai.ya.collection;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;

import java.util.Map;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/17 12:12
 */
public class TableTest {
    public static void main(String[] args) {
        //Map<key,Map< >>
        HashBasedTable<Object, Object, Object> table = HashBasedTable.create();
        table.put(1,2,3);
        System.out.println(table);
        table.put(1,2,4);
        System.out.println(table);
        Object o = table.get(1, 2);
        Map<Object, Object> row = table.row(1);
        Map<Object, Object> column = table.column(2);
    }
}
