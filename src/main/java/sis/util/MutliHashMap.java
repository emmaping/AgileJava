/********************************************************************
 * File Name:    MutliHashMap.java
 *
 * Date Created: 2015年2月12日
 *
 * ------------------------------------------------------------------
 * Copyright (C) 2010 Symantec Corporation. All Rights Reserved.
 *
 *******************************************************************/

// PACKAGE/IMPORTS --------------------------------------------------
package sis.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TODO: Update with a detailed description of the interface/class.
 * @param <K>
 *
 */
public class MutliHashMap<K, V>
{
  private Map<K, List<V>> map = new HashMap<K, List<V>>();

  public int size()
  {
    return map.size();
  }

  public void put(K key, V value)
  {
    List<V> values = map.get(key);
    if (values == null)
    {
      values = new ArrayList<V>();
      map.put(key, values);
    }
    values.add(value);
  }

  public List<V> get(K key)
  {
    return map.get(key);
  }

}
