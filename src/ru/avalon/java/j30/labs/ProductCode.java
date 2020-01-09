package ru.avalon.java.j30.labs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Класс описывает представление о коде товара и отражает соответствующую 
 * таблицу базы данных Sample (таблица PRODUCT_CODE).
 * 
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class ProductCode {
    /**
     * Код товара
     */
    private String code;
    /**
     * Кода скидки
     */
    private char discountCode;
    /**
     * Описание
     */
    private String description;
    /**
     * Основной конструктор типа {@link ProductCode}
     * 
     * @param code код товара
     * @param discountCode код скидки
     * @param description описание 
     */
    public ProductCode(String code, char discountCode, String description) {
        this.code = code;
        this.discountCode = discountCode;
        this.description = description;
    }
    /**
     * Инициализирует объект значениями из переданного {@link ResultSet}
     * 
     * @param set {@link ResultSet}, полученный в результате запроса, 
     * содержащего все поля таблицы PRODUCT_CODE базы данных Sample.
     */
    private ProductCode(ResultSet set) throws SQLException {
        code = set.getString("PROD_CODE");
        discountCode = set.getString("DISCOUNT_CODE").charAt(0);
        description = set.getString("DESCRIPTION");
        /*
         * TODO #05 реализуйте конструктор класса ProductCode
         */
        
        //throw new UnsupportedOperationException("Not implemented yet!");        
    }
    /**
     * Возвращает код товара
     * 
     * @return Объект типа {@link String}
     */
    public String getCode() {
        return code;
    }
    /**
     * Устанавливает код товара
     * 
     * @param code код товара
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * Возвращает код скидки
     * 
     * @return Объект типа {@link String}
     */
    public char getDiscountCode() {
        return discountCode;
    }
    /**
     * Устанавливает код скидки
     * 
     * @param discountCode код скидки
     */
    public void setDiscountCode(char discountCode) {
        this.discountCode = discountCode;
    }
    /**
     * Возвращает описание
     * 
     * @return Объект типа {@link String}
     */
    public String getDescription() {
        return description;
    }
    /**
     * Устанавливает описание
     * 
     * @param description описание
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Хеш-функция типа {@link ProductCode}.
     * 
     * @return Значение хеш-кода объекта типа {@link ProductCode}
     */
    @Override
    public int hashCode() {
        return Objects.hash(code, description, discountCode);
        /*
         * TODO #06 Реализуйте метод hashCode
         */
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Сравнивает некоторый произвольный объект с текущим объектом типа 
     * {@link ProductCode}
     * 
     * @param obj Объект, скоторым сравнивается текущий объект.
     * @return true, если объект obj тождественен текущему объекту. В обратном 
     * случае - false.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        ProductCode other = (ProductCode) obj;
        if (!Objects.equals(code, other.getCode()) ||
            (!Objects.equals(description, other.getDescription()) ||
            (!Objects.equals(discountCode, other.getDiscountCode())))) return false;
        return true;
        
        /*
         * TODO #07 Реализуйте метод equals
         */
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает строковое представление кода товара.
     * 
     * @return Объект типа {@link String}
     */
    @Override
    public String toString() {
        
        return new String (code + " " + discountCode +" "+ description);
        /*
         * TODO #08 Реализуйте метод toString
         */
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает запрос на выбор всех записей из таблицы PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getSelectQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM PRODUCT_CODE";        
        return connection.prepareStatement(query);
        
        
        /*
         * TODO #09 Реализуйте метод getSelectQuery
         */
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает запрос на добавление записи в таблицу PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getInsertQuery(Connection connection) throws SQLException {
        String sql = "insert into PRODUCT_CODE values (?,?,?)";
        PreparedStatement state = connection.prepareCall(sql);
        return state;
        /*
         * TODO #10 Реализуйте метод getInsertQuery
         */
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает запрос на обновление значений записи в таблице PRODUCT_CODE 
     * базы данных Sample
     * 
     * @param connection действительное соединение с базой данных
     * @return Запрос в виде объекта класса {@link PreparedStatement}
     */
    public static PreparedStatement getUpdateQuery(Connection connection) throws SQLException {
        String sql = "update PRODUCT_CODE set DISCOUNT_CODE = ?, set DESCRIPTION = ?, set PROD_CODE = ? ";
        PreparedStatement state = connection.prepareCall(sql);
        return state;
        /*
         * TODO #11 Реализуйте метод getUpdateQuery
         */
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Преобразует {@link ResultSet} в коллекцию объектов типа {@link ProductCode}
     * 
     * @param set {@link ResultSet}, полученный в результате запроса, содержащего 
     * все поля таблицы PRODUCT_CODE базы данных Sample
     * @return Коллекция объектов типа {@link ProductCode}
     * @throws SQLException 
     */
    public static Collection<ProductCode> convert(ResultSet set) throws SQLException {
        Collection<ProductCode> prodCod = new LinkedList<>();
        while (set.next()) {
            ProductCode value = new ProductCode(set);
            prodCod.add(value);
        }
        return new ArrayList<> (prodCod);
        /*
         * TODO #12 Реализуйте метод convert
         */
       // throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Сохраняет текущий объект в базе данных. 
     * <p>
     * Если запись ещё не существует, то выполняется запрос типа INSERT.
     * <p>
     * Если запись уже существует в базе данных, то выполняется запрос типа UPDATE.
     * 
     * @param connection действительное соединение с базой данных
     */
    public void save(Connection connection) throws SQLException {
        Collection <ProductCode> prodCode = all(connection);
        if (prodCode.contains(this)) {
            try (PreparedStatement statement = getUpdateQuery(connection)){
                statement.setString(1, String.valueOf(discountCode));
                statement.setString(2, description);
                statement.setString(3, code);
                statement.executeUpdate();
                
            }
        
        }
        else {
            try (PreparedStatement statement = getInsertQuery(connection)) {
                statement.setString(1, code);
                statement.setString(2, String.valueOf(discountCode));
                statement.setString(3, description);
                statement.executeUpdate();
                
            }
        }
        /*
         * TODO #13 Реализуйте метод convert
         */
        //throw new UnsupportedOperationException("Not implemented yet!");
    }
    /**
     * Возвращает все записи таблицы PRODUCT_CODE в виде коллекции объектов
     * типа {@link ProductCode}
     * 
     * @param connection действительное соединение с базой данных
     * @return коллекция объектов типа {@link ProductCode}
     * @throws SQLException 
     */
    public static Collection<ProductCode> all(Connection connection) throws SQLException {
        
        try (PreparedStatement statement = getSelectQuery(connection)) {
            try (ResultSet result = statement.executeQuery()) {
                return convert(result);
            }
        }
    }
}
