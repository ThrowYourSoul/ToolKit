package com.eleven.toolkit;

import java.util.Collection;
import java.util.List;

public class CollectionUtil {

    /**
     * @param collection Collection<?>
     * @return true表示list为空，false表示非空
     */
    public static boolean isEmpty(Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }


    public static boolean isNotEmpty(Collection<?> collection) {
        return !CollectionUtil.isEmpty(collection);
    }

    /**
     * 列表不为空且元素都不为空
     */
    public static boolean isItemAllNotEmpty(List<?> collection) {
        try {
            if (isEmpty(collection)) {
                return false;
            } else {
                int size = collection.size();
                for (int i = 0; i < size; i++) {
                    if (collection.get(i) == null) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable t) {
            t.printStackTrace();
            return false;
        }
    }

    /**
     * 列表元素为空或者列表元素都为空
     */
    public static boolean isItemAllEmpty(List<?> collection) {
        try {
            if (isEmpty(collection)) {
                return true;
            } else {
                int size = collection.size();
                for (int i = 0; i < size; i++) {
                    if (collection.get(i) != null) {
                        return false;
                    }
                }
                return true;
            }
        } catch (Throwable t) {
            t.printStackTrace();
            return true;
        }
    }

}
