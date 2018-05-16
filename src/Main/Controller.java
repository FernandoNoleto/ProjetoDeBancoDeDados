
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
            PreparedStatement stmt = con.prepareStatement("select * from jogadores");
            ResultSet rs = stmt.executeQuery();
            
            int brasil = 0;
            int countb = 0;
            int argentina = 0;
            int counta = 0;
            
            
            while (rs.next()) {
                System.out.println("------------------------------");
                System.out.println("Jogador:. "+rs.getString("nome"));
                System.out.println("Selecao:. "+rs.getString("selecao"));
                System.out.println("Overall:. "+rs.getInt("overall"));
                System.out.println("Posição:. "+rs.getString("posicao"));
                if("Brazil".equals(rs.getString("selecao"))){
                    countb++;
                    brasil += rs.getInt("overall");
                }
                if("Argentina".equals(rs.getString("selecao"))){
                    counta++;
                    argentina += rs.getInt("overall");
                }
            }
            
            float media_brasil = (float)brasil/countb;
            float media_argentina = (float)argentina/counta;
            
            if(media_brasil >= media_argentina){
                System.out.println("Brasil hexa!");
            }
            else{
                System.out.println("Argentina ganhou!");
            }
            
            System.out.println("Media Brasil:. "+media_brasil);
            System.out.println("Media Argentina:. "+media_argentina);
            
            
            rs.close();
            stmt.close();
        }
        
    }
}
