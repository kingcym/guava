package com.cai.ya.collection;

import com.google.common.collect.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/**
 * @Author: Kingcym
 * @Description:
 * @Date: 2018/11/17 0:10
 */
public class MapTest {
    public static void main(String[] args) {
        //map构建
        HashMap<Object, Object> hashMap = Maps.newHashMap();
        Maps.newHashMapWithExpectedSize(5);
        ConcurrentMap<Object, Object> concurrentMap = Maps.newConcurrentMap();//线程安全map
        ImmutableMap<Object, Object> immutableMap = ImmutableMap.builder()
                .put(1, "文文是猪").build();

        //map初始化并赋值
        Map<Integer, String> map = Maps.asMap(Sets.newHashSet(1, 2, 3), k -> k + "_value");
        System.out.println(map);//{1=1_value, 2=2_value, 3=3_value}
        ImmutableMap<String, Integer> map1 = Maps.uniqueIndex(Lists.newArrayList(1, 2, 3), v -> v + "_key");
        System.out.println(map1);//{1_key=1, 2_key=2, 3_key=3}

        //map修改value
        Map<Integer, String> map2 = Maps.transformValues(map, v -> v + "transformValues");
        System.out.println(map2);//{1=1_valuetransformValues, 2=2_valuetransformValues, 3=3_valuetransformValues}

        //按key过滤
        Map<Integer, String> map3 = Maps.filterKeys(map, key -> key == 1);
        System.out.println(map3);//{1=1_value}




    }
}
