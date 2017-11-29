package com.yonyou.microservice.wechat.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xiaoleilu.hutool.exceptions.UtilException;

/**
 * MAP和对象相互转换的工具类
 * 
 * @author BENJAMIN
 *
 */
public class MapConverUtil {

	private static Logger log = LoggerFactory.getLogger(MapConverUtil.class);

	/**
	 * 对象转MAP，会全部转成大写key
	 * 
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> PO2Map(Object o) {
		Map<String, Object> map = new HashMap<>();
		String clzName = o.getClass().getSimpleName();
		log.info("类：" + o.getClass().getName());
		Field[] fields = o.getClass().getDeclaredFields();
		log.info("***" + clzName + "转map开始****");
		try {
			for (Field field : fields) {
				field.setAccessible(true);
				String proName = field.getName();
				Object proValue = field.get(o);
				map.put(proName.toUpperCase(), proValue);
				log.info("key：" + proName + "value:" + proValue);

			}
		} catch (Exception e) {
			log.error("***" + e.getMessage(), e);
		}
		log.info("***" + clzName + "转map结束****");
		return map;
	}

	/**
	 * MAP转对象，不严格匹配，仅返回包含的字段
	 * 
	 * @param map
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static Object map2PO(Map<String, Object> map, Object o) {
		try {
			if (!map.isEmpty()) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Field[] fields = o.getClass().getDeclaredFields();
					String clzName = o.getClass().getSimpleName();
					log.info("类：" + o.getClass().getName());
					log.info("***map转" + clzName + "开始****");
					for (Field field : fields) {
						int mod = field.getModifiers();
						if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
							continue;
						}

						if (field.getName().toUpperCase().equals(entry.getKey())
								|| field.getName().equals(entry.getKey())) {
							Class c = field.getType();
							field.setAccessible(true);
							if (entry.getValue() != null && c == Long.class) {
								field.set(o, new Long(entry.getValue().toString()));
							} else if (entry.getValue() != null && c == Date.class) {
								Class tmp = entry.getValue().getClass();
								if (tmp == Long.class) {
									Date a = new Date(new Long(entry.getValue().toString()));
									field.set(o, a);
								} else {
									field.set(o, entry.getValue());
								}
							} else {
								field.set(o, entry.getValue());
							}
							log.info("key：" + entry.getKey() + "value:" + entry.getValue());
						}

					}
					log.info("***map转" + clzName + "结束****");
				}
			}
		} catch (Exception e) {
			log.error("***" + e.getMessage(), e);
		}
		return o;
	}

	/**
	 * 严格匹配每个字段 支持全大小 有字段未在Map中找到会抛出异常
	 * 
	 * @param map
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static Object map2POStrict(Map<String, Object> map, Object o) {
		try {
			if (!map.isEmpty()) {
				Field[] fields = null;
				fields = o.getClass().getDeclaredFields();
				log.info("类：" + o.getClass().getName());

				for (Field field : fields) {
					int mod = field.getModifiers();
					Class c = field.getType();
					if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
						continue;
					}

					boolean isfind = false;
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						if (field.getName().toUpperCase().equals(entry.getKey())
								|| field.getName().equals(entry.getKey())) {
							isfind = true;
							field.setAccessible(true);

							if (entry.getValue() != null && c == Long.class) {
								field.set(o, new Long(entry.getValue().toString()));
							} else if (entry.getValue() != null && c == Date.class) {
								Class tmp = entry.getValue().getClass();
								if (tmp == Long.class) {
									Date a = new Date(new Long(entry.getValue().toString()));
									field.set(o, a);
								} else {
									field.set(o, entry.getValue());
								}
							} else {
								field.set(o, entry.getValue());
							}

							log.info("key：" + entry.getKey() + "value:" + entry.getValue());
						}
					}
					if (!isfind) {
						log.error("没用找到字段" + field.getName() + "在map中对应的映射");
						throw new UtilException("没用找到字段" + field.getName() + "在map中对应的映射");
					}
				}

			}
		} catch (Exception e) {
			log.error("***" + e.getMessage(), e);
		}
		return o;
	}
}