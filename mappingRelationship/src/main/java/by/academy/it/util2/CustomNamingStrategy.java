package by.academy.it.util2;

import org.hibernate.cfg.DefaultNamingStrategy;

public class CustomNamingStrategy extends DefaultNamingStrategy {
    public String classToTableName(String className) {
        return "T_" + super.classToTableName(className).toUpperCase();
    }

    public String propertyToColumnName(String propName) {
        return "F_" + super.propertyToColumnName(propName).toUpperCase();
    }

    public String columnName(String columnName) {
        return columnName;
    }

    public String tableName(String tableName) {
        return tableName;
    }
}
