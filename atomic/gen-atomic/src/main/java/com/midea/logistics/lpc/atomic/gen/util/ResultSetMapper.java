package com.midea.logistics.lpc.atomic.gen.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSetMapper {
    private static final Logger logger = LoggerFactory.getLogger(ResultSetMapper.class);

    public ResultSetMapper() {
    }

    public static List<Map> toMapList(ResultSet rs) {
        ArrayList list = new ArrayList();

        try {
            try {
                ResultSetMetaData meta = rs.getMetaData();

                while (rs.next()) {
                    Map<String, Object> map = new HashMap();

                    for (int i = 1; i <= meta.getColumnCount(); ++i) {
                        String colName = meta.getColumnLabel(i);
                        colName = StringUtil.underlineToCamel(colName);
                        Object value = rs.getObject(i);
                        if (value != null) {
                            map.put(colName, value);
                        }
                    }

                    list.add(map);
                }
            } catch (Exception var10) {
                logger.error("Exception", var10);
            }

            return list;
        } finally {
            ;
        }
    }
}
