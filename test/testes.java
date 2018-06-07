
import Main.Controller;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author fernando
 */
public class testes {
    public static void main(String[] args) throws SQLException {
        Controller c = new Controller();
        for(int i = 0; i < 100; i++)
            System.out.println(c.Zebra());
        ArrayList classificacao = c.grupoA();
        System.out.println(classificacao);
        
    }
}
