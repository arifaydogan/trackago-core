package tr.com.trackago.tautil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionsUtil {
    public static boolean isCollectionEmpty(Collection<?> c) {
        return ObjectUtil.isEmpty(c) ? true : c.size() == 0;
    }

    public static boolean isCollectionNotEmpty(Collection<?> c) {
        return ObjectUtil.isNotEmpty(c) ? c.size() > 0 : false;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null ? true : collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return collection == null ? false : collection.size() > 0;
    }

    /**
     * Herhangi bir nesnenin listesinin istenen alanındaki değerleri liste olarak döndürür.
     * Listenin hangi nesneye ait olduğu önemli değildir. alan adı olarak gönderilen
     * değerin büyük küçük harf duyarlılığı yoktur.
     * <p>
     * Örnek olarak ;
     * List<EmlArsa> arsaListesi adında bir listemiz olsun. Bu Listeden
     * sadece arsaNo alanındaki değerleri bir liste olarak almak istediğimizde
     * getFieldsInList(arsaListesi,'arsaNo') yazdığımızda bize arsaNoları alan bir list dönmektedir.
     *
     * @param objList istenilen alanın içinde bulunduğu nesneye ait liste
     * @param alanAdi listesinin dönmesini istediğimiz alanının adı
     * @return Liste içinde ki alan adına ait değerlerin bulunduğu List
     * @author Arif Hüsnü Aydoğan
     */
    public static <T> List<T> getFieldsInList(List<?> objList, String alanAdi) {
        List<T> degerListesi = new ArrayList<T>();
        for (Object obj : objList) {
            Class<? extends Object> c1 = obj.getClass();
            Field[] fields = c1.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                String name = fields[i].getName();
                if (alanAdi != null && !alanAdi.equalsIgnoreCase(name)) {
                    continue;
                }
                fields[i].setAccessible(true);
                Object value = null;
                try {
                    value = fields[i].get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                degerListesi.add((T) value);
            }
        }
        return degerListesi;
    }

    public static <T extends Object> List<List<T>> splitListToSubLists(List<T> parentList, int subListSize) {
        List<List<T>> subLists = new ArrayList<List<T>>();
        if (subListSize > parentList.size()) {
            subLists.add(parentList);
        } else {
            int remainingElements = parentList.size();
            int startIndex = 0;
            int endIndex = subListSize;
            do {
                List<T> subList = parentList.subList(startIndex, endIndex);
                subLists.add(subList);
                startIndex = endIndex;
                if (remainingElements - subListSize >= subListSize) {
                    endIndex = startIndex + subListSize;
                } else {
                    endIndex = startIndex + remainingElements - subList.size();
                }
                remainingElements -= subList.size();
            } while (remainingElements > 0);

        }
        return subLists;
    }

}
