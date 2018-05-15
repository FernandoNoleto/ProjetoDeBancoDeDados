
package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author fernando
 */
public class Controller {
    private void AcessarBanco(){
        ConnectionFactory conexao = new ConnectionFactory();
        try{
            conexao.getConnection();
            System.out.println("Deu certo");
        }
        catch(Exception e){
            System.out.println("ERRO: "+e);
        }
    }
    
    public void LerBanco() throws SQLException{
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement stmt = con.prepareStatement("select * from equipes.brasil");
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                System.out.println("------------------------------");
                System.out.println("Jogador:. "+rs.getString("nome_jogador"));
                System.out.println("Overall:. "+rs.getInt("overall"));
                System.out.println("Posição:. "+rs.getString("posicao"));
            }
            rs.close();
            stmt.close();
        }
        
    }
}
