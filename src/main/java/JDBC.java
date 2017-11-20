import java.sql.*;

public class JDBC {

    public static void main(String[] args) throws Exception {

        // передаем в нашу функцию имя роли
        // сначала вызовем для user, затем для administrator
        getData("user");
        getData("administrator");
    }


    public static void getData(String role) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://127.0.0.1/test";
        String login = "root";
        String password = "";
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, login, password); //соединяемся с БД

        String[] result = new String[3];
        PreparedStatement preparedStatement = null;
        preparedStatement = connection.prepareStatement("select login, " +
                "password, role from peoples where role =" + "?");

        // устанавливаем значение нашего параметра,
        preparedStatement.setString(1, role);


        ResultSet resultquery = preparedStatement.executeQuery();

        if (resultquery.next()) {
            result[0] = resultquery.getString("login");
            result[1] = resultquery.getString("password");
            result[2] = resultquery.getString("role");
        }


        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
        }

    }
}
        /*
        Statement st = connection.createStatement();
        ResultSet stt = PreparedStatement(st.executeQuery("select login, password, role from peoples where role =" + "'" + role + "'");

        // объявляем массив, в котором будет хранится пара логин-пароль + название роли
        String[] result = new String[3];

        // получаем из записи значения и передаем их в элементы массива
        if (stt.next()) { result[0] = stt.getString("login");
            result[1] = stt.getString("password"); result[2] = stt.getString("role");}

        // можно напечатать наш массив
        for (int i = 0; i < result.length; i++)
        {
            System.out.print(result[i]);
        }
    }
*/
