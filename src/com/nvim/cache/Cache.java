
package com.nvim.cache;

/**
 * @author seishuchen
 */
public interface Cache {
    boolean set(String key, Object value);

    Object get(String key);
}
