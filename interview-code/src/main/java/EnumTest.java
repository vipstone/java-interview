public class EnumTest {
    public static void main(String[] args) {
        System.out.println(DBEnum.MYSQL);
    }
}

enum DBEnum {
    ORACLE,
    DB2,
    MYSQL,
    SQLSERVER
}
